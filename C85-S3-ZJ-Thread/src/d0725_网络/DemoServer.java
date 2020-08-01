package d0725_网络;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;
/**
 * QQ模拟
 * @author Administrator
 *
 */
public class DemoServer {
    public static void main(String[] args) throws IOException {
    	ServerSocket server=new ServerSocket(8888);
    	System.out.println("服务器启动，监听8888端口");
    	//接受客户端的连接
    	//io操作导致程序再次阻塞
    	Socket scoket=server.accept();
    	
    	InetAddress myAddress= scoket.getInetAddress();
    	SocketAddress otherAddress=scoket.getLocalSocketAddress();
    	System.out.println("我的地址"+myAddress);
    	System.out.println("客户端的地址"+otherAddress);
    	
    	InputStream in=scoket.getInputStream();
    	OutputStream out=scoket.getOutputStream();
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
    					System.out.println("我说：");
    					out.write(sc.nextLine().getBytes());
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}.start();
    	
    	
    	
    	
		
    	
	}
}
