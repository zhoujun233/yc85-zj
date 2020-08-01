package d0725_网络;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DemoUrl {
	public static void main(String[] args) throws IOException {
		URL url=new URL("http://47.92.134.75:8080/C85-S2-TTSX/index.html");
		
		System.out.println(url.getProtocol());//获取url的协议
		System.out.println(url.getPort());//获取url的端口
		System.out.println(url.getHost());//获取url的域名
		System.out.println(url.getPath());//获取url的资源路径
		System.out.println(url.getQuery());//获取url的参数
		System.out.println(url.getFile());//获取url的资源名
		
		URLConnection conn=url.openConnection();
		System.out.println(conn.getLastModified());//目标资源最后修改时间
		System.out.println(conn.getContentLengthLong());//目标资源大小
		System.out.println(conn.getContentType());//目标资源类型
		
		System.out.println("--------------");
		
		InputStream in=conn.getInputStream();//获取输入流
		
		byte[] buff=new byte[1024];
		int count;
		while((count=in.read(buff))>0) {
			System.out.println(new String(buff,0,count));
		}
		in.close();
	}

}
