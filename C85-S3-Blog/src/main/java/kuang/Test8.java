package kuang;


import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.collections.SynchronizedQueue;

public class Test8 {
	public static  void main(String[] args) {
		SynchronizedQueue<String> arrayBlockingQueue=new SynchronizedQueue<>();
		//存
		new Thread(()->{
			try {
				arrayBlockingQueue.offer("a");
				System.out.println(Thread.currentThread().getName()+arrayBlockingQueue.offer("a"));
				TimeUnit.SECONDS.sleep(2);
				arrayBlockingQueue.offer("a");
				System.out.println(Thread.currentThread().getName()+arrayBlockingQueue.offer("b"));
				TimeUnit.SECONDS.sleep(2);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}) .start();
		
		//取
				new Thread(()->{
					try {
						arrayBlockingQueue.poll();
						System.out.println(Thread.currentThread().getName()+"======="+arrayBlockingQueue.poll());
						TimeUnit.SECONDS.sleep(2);
						arrayBlockingQueue.poll();
						System.out.println(Thread.currentThread().getName()+"======="+arrayBlockingQueue.poll());
						TimeUnit.SECONDS.sleep(2);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}) .start();
	}

}
