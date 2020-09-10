package d0725_多线程;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDown implements Runnable{
	
	public static void main(String[] args) {
		Date starttime=new Date(System.currentTimeMillis());
		
		while (true) {
			try {
				Thread.currentThread();
				Thread.sleep(1000);
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(starttime));
				starttime=new Date(System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	

	

}
