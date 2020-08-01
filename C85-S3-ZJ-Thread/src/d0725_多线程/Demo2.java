package d0725_多线程;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
	private List<String>list=new ArrayList<>();
	
	//同步方法
	public synchronized void add(String i) {
		list.add(i);
	}
	
	public  String pop() {
		//同步块   （this）同步资源对象   也就是要锁定的对象
		synchronized(this) {
			return list.remove(0);
		}
	}
	
	public synchronized int size() {
		return list.size();
	}
	public void test() {
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		Demo2 d=new Demo2();
		
		Thread t1=new Thread("线程1") {
			public void run() {
				while(true) {
					if(d.size()<10) {
						for(int i=0;i<10;i++) {
							d.add(""+i);
						}
					}
				}
			}
		};
		
		Thread t2=new Thread("==线程2") {
			public void run() {
				while(true) {
					if(d.size()>0) {
						System.out.println(Thread.currentThread()+":"+d.pop());
					}
				}
			}
		};
		
		Thread t3=new Thread("=====线程3") {
			public void run() {
				while(true) {
					if(d.size()>0) {
						System.out.println(Thread.currentThread()+":"+d.pop());
					}
				}
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}
}
