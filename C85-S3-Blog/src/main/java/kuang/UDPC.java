package kuang;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPC {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket=null;
		try {
			 socket=new DatagramSocket();
			InetAddress ia=InetAddress.getLocalHost();
			int port=6666;
			String msg="你好，服务器。";
			DatagramPacket dp=new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length,ia,port);
			 socket.send(dp);
		} catch (SocketException e) {
			e.printStackTrace();
		}finally {
			socket.close();
		}
		
	}

}
