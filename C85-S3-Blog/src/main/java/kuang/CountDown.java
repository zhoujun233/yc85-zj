package kuang;

import java.util.concurrent.CountDownLatch;

public class CountDown {
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch c=new CountDownLatch(6);
		for(int i=1;i<=6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"go out");
				c.countDown();
			}) .start();
		}
		c.await();
		System.out.println("close");
	}

}
