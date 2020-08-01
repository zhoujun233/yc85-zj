package d0726;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 1.单线程下载 
 * 2.单线程分块下载
 * @author Administrator
 *
 */

public class Demo {
	public static void main(String[] args) throws IOException {
		URL url=new URL("https://mirrors.bfsu.edu.cn/apache/tomcat/tomcat-10/v10.0.0-M7/src/apache-tomcat-10.0.0-M7-src.zip");
		URLConnection conn=url.openConnection();
		System.out.println("下载开始");
		InputStream in=conn.getInputStream();
		FileOutputStream out=new FileOutputStream("d:/apache-tomcat-10.0.0-M7-src.zip");
		byte[] buffer=new byte[1024];
		int count;
		while((count=in.read(buffer))>0) {
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		System.out.println("下载完成");
		
	}

}
