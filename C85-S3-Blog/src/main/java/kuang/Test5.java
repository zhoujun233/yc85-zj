package kuang;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test5 {

	public static void main(String[] args) {
		// 抢车位
		Semaphore semaphore = new Semaphore(3);
		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				// acquire()得到车位
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "抢到车位");
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread().getName() + "离开车位");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					semaphore.release();// 释放车位
				}
			}, String.valueOf(i)).start();
		}
	}

}
