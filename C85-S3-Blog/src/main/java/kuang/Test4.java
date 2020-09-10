package kuang;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test4 {
	
	public static void main(String[] args) {
		CyclicBarrier c=new CyclicBarrier(7,()->{
			System.out.println("这是一个加法计数器");
		}) ;
		
		for(int i=1;i<=7;i++) {
			final int temp=i;
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"第"+temp);
				try {
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
		}
	}

}
