package kuang;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo4 {
	//volatile不保证原子性
	private static volatile AtomicInteger num=new AtomicInteger();
	
	public static void add() {
		num.getAndIncrement();//CAS
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<20;i++) {
			new Thread(()->{
				for(int j=0;j<1000;j++) {
					add();
				}
			}) .start();
		}
		//main  guc垃圾回收
		while(Thread.activeCount()>2) {
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName()+"=="+num);
	}

}
