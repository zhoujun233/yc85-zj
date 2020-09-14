package kuang;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpC {
	public static void main(String[] args) {
		Socket scoket=null;
		OutputStream os=null;
		try {
			scoket=new Socket("127.0.0.1",6666);
			 os=scoket.getOutputStream();
			os.write("上午好呀".getBytes());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (scoket != null) {
				try {
					scoket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
