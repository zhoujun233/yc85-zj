package kuang;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {
	public static void main(String[] args) {
		Ticket2 t=new Ticket2();
		//兰姆达表达式，并发编程，多个线程操作同一资源
		
		
		new Thread(()->{
			for(int i=0;i<20;i++) t.sale();
		},"B") .start();
		
		new Thread(()->{
			for(int i=0;i<20;i++) t.sale();
		},"A") .start();
		
		new Thread(()->{
			for(int i=0;i<20;i++) t.sale();
		},"C") .start();
		
		
	}

}
class Ticket2{
	private int num=50;
	//lock锁
	Lock lock=new ReentrantLock();
	public synchronized void sale() {
		lock.lock();
		try {
			for(int i=0;i<50;i++) {
				if(num>0) {
					System.out.println(Thread.currentThread()+"买了"+num--+"剩余"+num);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
}
