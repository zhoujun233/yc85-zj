package d0727;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tomcat {
	public static void main(String[] args) throws IOException {
		ServerSocket sever=new ServerSocket(8080);
		
		boolean runing=true;
		while(runing) {
			Socket socket=sever.accept();
			new Thread(){
				public void run() {
				try {
					byte[]buffer=new byte[1024];
					int count;
					InputStream in =socket.getInputStream(); 
					
					OutputStream out=socket.getOutputStream();
					count=in.read(buffer);
					if(count>0) {
						//打印请求报文
						String requestText=new String(buffer,0,count);
						System.out.println(requestText);
						String lines[]=requestText.split("\\n");
						String Requestlines[]=lines[0].split("\\s");
						String webpath=Requestlines[1];
						String path="E:/Tomcat/webapps/"+webpath;
						String ContentType;
						//结果码
						int statuscode=200;
						File file=new File(path);
						if(!file.exists()) {
							statuscode=404;
							path="E:/Tomcat/webapps/photo/404.html";
						}
						if(webpath.endsWith(".js")) {
							ContentType="application/javascript; charset=utf-8";
						}else if(webpath.endsWith(".css")) {
							ContentType="text/css; charset=utf-8";
						}else {//图片能被html解析
							ContentType="text/html; charset=utf-8";
						}
						
						//响应头行
						out.write(("HTTP/1.1 "+statuscode+" OK\n").getBytes());
						//响应头域
						out.write(("Content-Type: "+ContentType+"\n").getBytes());
						//空行
						out.write("\n".getBytes());
						//实体
						//out.write("<h1>Hi好</h1>".getBytes());
						
						
						FileInputStream fis=new FileInputStream(path);
						while((count=fis.read(buffer))>0) {
							
							out.write(buffer,0,count);
							
						}
						fis.close();
					}
					
					socket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}	
				}
			}.start();
		}
		
		sever.close();
		
		
	}

}
