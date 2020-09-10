package kuang;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test7 {
	public static void main(String[] args) throws InterruptedException {
		test4();
	}
	
	public static void test1() {
		//队列的大小
		ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
		System.out.println(blockingQueue.add("a"));
		System.out.println(blockingQueue.add("b"));
		System.out.println(blockingQueue.add("v"));
		
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
		
		System.out.println(blockingQueue.element());
		
	}
	
	public static void test2() {
		//队列的大小
		ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
		System.out.println(blockingQueue.offer("a"));
		System.out.println(blockingQueue.offer("b"));
		System.out.println(blockingQueue.offer("v"));
		System.out.println(blockingQueue.offer("v"));
		
		
		  System.out.println(blockingQueue.poll());
		  System.out.println(blockingQueue.poll());
		  System.out.println(blockingQueue.poll());
		  System.out.println(blockingQueue.poll());
		 
		
		 System.out.println(blockingQueue.peek()); 
		
	}
	
	public static void test3() throws InterruptedException {
		//队列的大小
		ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
		blockingQueue.put("a");
		blockingQueue.put("a");
		blockingQueue.put("a");
		
		System.out.println(blockingQueue.take());
		System.out.println(blockingQueue.take());
		System.out.println(blockingQueue.take());
		
		
	}
	
	public static void test4() throws InterruptedException {
		//队列的大小
		ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
		System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
		
		System.out.println(blockingQueue.poll( 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.poll( 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.poll( 2, TimeUnit.SECONDS));
		System.out.println(blockingQueue.poll( 2, TimeUnit.SECONDS));
		
	}

}
