package kuang;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpS {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket scoket = null;
		InputStream is = null;
		ByteArrayOutputStream bas = null;
		try {
			server = new ServerSocket(6666);
			while(true) {
				scoket = server.accept();
				is = scoket.getInputStream();
				bas = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len;
				while ((len = is.read(buffer)) != -1) {
					bas.write(buffer, 0, len);
				}
				System.out.println(bas.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bas != null) {
				try {
					bas.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
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
			if (bas != null) {
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
