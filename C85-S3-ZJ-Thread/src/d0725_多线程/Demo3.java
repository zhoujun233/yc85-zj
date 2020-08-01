package d0725_多线程;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {//最简单的生产消费者模式
	private List<Integer>list=new ArrayList<>();
	
	public synchronized void product() throws InterruptedException {
		while(true) {
			if(list.isEmpty()) {
				for(int i=0;i<10;i++) {
					list.add(i);
					System.out.println("-------生产了一个商品"+i);
					Thread.sleep(200);
				}
			}else {
				/**
				 * 如果list不为空
				 */
				//通知等待线程   进入锁池
				notifyAll();
				//当前线程进入等待并释放锁对象
				wait();
			}
		}
	}
	public synchronized void consume() throws InterruptedException {
		while(true) {
			if(list.isEmpty()==false) {
				for(int i=0;i<10;i++) {
					list.remove(0);
					System.out.println("===消费了一个商品"+i);
					Thread.sleep(100);
				}
			}else {
				/**
				 * 如果list为空
				 */
				//通知等待线程   进入锁池
				notifyAll();
				//当前线程进入等待并释放锁对象
				wait();
			}
		}
	}
	public static void main(String[] args) {
		Demo3 d=new Demo3();
		
		new Thread() {
			public void run() {
				try {
					d.product();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				try {
					d.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}

}
