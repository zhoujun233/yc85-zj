package d0726;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 单,多线程分块下载
 * 
 * @author Administrator
 * 实现过程
 * 1. 单线程下载
 * 2. 单线程分块下载
 * 	  1. 获取文件总大小 (从conn获取)
 * 	  2. 每块的大小 (自定义)
 * 	  3. 字节流的 skip() 跳过N个字节
 * 3. 多线程分块下载
 */
public class Demo1 {
	// 正在下载块
	private int downNums = 0;
	String filename = "d:/apache-tomcat-10.0.0-M7-src.zip";

	public static void main(String[] args) throws IOException, InterruptedException {
		new Demo1().download();
	}

	public void download() throws IOException, InterruptedException {
		/**
		 * 忽略 SSL 验证  (高航提供)
		 */
		// SslUtils.ignoreSsl();
		
		URL url = new URL(
				"https://mirrors.bfsu.edu.cn/apache/tomcat/tomcat-10/v10.0.0-M7/src/apache-tomcat-10.0.0-M7-src.zip");
		URLConnection conn = url.openConnection();

		// 文件大小
		int filesize = conn.getContentLength();
		// 每块大小（2M）
		int blocksize = 2 * 1024 * 1024;
		// 计算块数
		int blocknums = filesize / blocksize;
		if (filesize % blocksize != 0) {
			blocknums++;
		}
		System.out.println("下载开始");
		long time = System.currentTimeMillis();

		for (int i = 0; i < blocknums; i++) {
			downNums++;
			int index = i;// jdk会自动对其加final
			
			// 在此等待,限制下载的个数  最大10个线程
			synchronized (this) {
				// 如果当前下载块大于0则继续等待
				while (downNums > 10) {
					wait();
				}
			}
			new Thread() {
				public void run() {
					try {
						System.out.println("第" + (index + 1) + "块开始下载");
						// 创建连接对象
						URLConnection conn = url.openConnection();
						InputStream in = conn.getInputStream();
						// 匿名类访问的外部变量必须是final修饰的变量
						FileOutputStream out = new FileOutputStream(filename + index);
						// 开始下的字节数
						int beginbytes = index * blocksize;
						int endbytes = beginbytes + blocksize;
						if (endbytes > filesize) {
							endbytes = filesize;
						}
						// 跳过字节数
						in.skip(beginbytes);
						// 当前下载到的位置
						int postion = beginbytes;

						byte[] buffer = new byte[1024];
						int count;
						while ((count = in.read(buffer)) > 0) {
							if (postion + count > endbytes) {
								// 计算超出部分
								int a = postion + count - endbytes;
								// 移除超出部分
								count -= a;
							}
							out.write(buffer, 0, count);
							// 更新下载位置
							postion += count;
							if (postion > endbytes) {
								break;
							}
						}
						in.close();
						out.close();
						System.out.println("第" + (index + 1) + "块结束下载");
						// 匿名类中访问外部类对象的方式是Demo1.this
						synchronized (Demo1.this) {
							Demo1.this.downNums--;
							// 通知主线程，尝试合并文件
							Demo1.this.notify();
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}.start();
		}
		// 在此等待
		synchronized (this) {
			// 如果当前下载块大于0则继续等待
			while (downNums > 0) {
				wait();
			}
		}
		// 合并文件
		marge(filename, blocknums);

		/**
		 * 清空小文件
		 */
		for (int j = 0; j < blocknums; j++) {
			File file = new File(filename + j);
			file.delete();
		}

		System.out.println("共花" + (System.currentTimeMillis() - time) / 1000 + "秒时间");
		System.out.println("下载完成");
	}

	/**
	 * 合并文件
	 * 
	 * @throws IOException
	 */
	public static void marge(String path, int filenums) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		for (int i = 0; i < filenums; i++) {
			FileInputStream fis = new FileInputStream(path + i);
			byte[] buffer = new byte[1024];
			int count;
			while ((count = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, count);
			}
			fis.close();
		}
		fos.close();
	}

}
