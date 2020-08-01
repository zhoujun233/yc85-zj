package loadfile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		//只要new Socket就会立即和服务器进行连接
    	//默认使用随机端口
    	Socket scoket=new Socket("127.0.0.1",6666);
    	InetAddress myAddress= scoket.getInetAddress();
    	SocketAddress otherAddress=scoket.getLocalSocketAddress();
    	System.out.println("我的地址"+myAddress);
    	System.out.println("服务器的地址"+otherAddress);
    	
    	InputStream in=scoket.getInputStream();
    	OutputStream out=scoket.getOutputStream();
    	FileInputStream fis=new FileInputStream("e:/test.txt");
    	Scanner sc=new Scanner(System.in);

    	new Thread() {
    		byte[]buffer=new byte[1024];
        	int count;
    		public void run() {
    			while(true) {//读
    				try {
						count=in.read(buffer);
						System.out.println("他说："+new String(buffer,0,count));
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}.start();
    	
    	new Thread() {
    		public void run() {
    			while(true) {//写
    				try {
    					System.out.println("输入1发送test.txt文件:");
    					if(sc.nextLine().equals(1)) {
    						System.out.println("文件已发送");
    						byte[]buffer=new byte[1024];
    			        	int count;
    			        	count=fis.read(buffer);
    			        	out.write((new String(buffer,0,count)).getBytes());
    			        	
    			        	
    					}else {
    						System.out.println("我说：");
        					out.write(sc.nextLine().getBytes());
    					}
    					
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}.start();
    	
	}

}
