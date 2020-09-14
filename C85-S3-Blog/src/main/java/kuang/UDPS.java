package kuang;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPS {
   public static void main(String[] args) throws IOException {
	   DatagramSocket socket=null;
		try {
			 socket=new DatagramSocket(6666);
			 byte [] buffer=new byte[1024];
			DatagramPacket dp=new DatagramPacket(buffer, 0, buffer.length);
			 socket.receive(dp);
			 System.out.println(new String(dp.getData(),0,dp.getLength()));
		} catch (SocketException e) {
			e.printStackTrace();
		}finally {
			socket.close();
		}
		
}
}
