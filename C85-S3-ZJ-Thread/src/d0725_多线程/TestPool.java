package d0725_多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
	public static void main(String[] args) {
		//创建服务   向线程池里面添加线程
		ExecutorService pool =Executors.newFixedThreadPool(10);
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		//关闭服务
		pool.shutdown();
	}

}
class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
	}
	
}

