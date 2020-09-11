package kuang;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Demo {
	
	AtomicReference<Thread> ato=new AtomicReference<>();
	
	
	public void mylock() {
		Thread thread=Thread.currentThread();
		System.out.println(thread.currentThread().getName()+"ok1");
		
		//自旋锁
		while(!ato.compareAndSet(null, thread)) {
			
		}
		
	}
	
	public void myunlock() {
		Thread thread=Thread.currentThread();
		System.out.println(thread.currentThread().getName()+"ok2");
		ato.compareAndSet(thread, null);
		
		
	}

}
