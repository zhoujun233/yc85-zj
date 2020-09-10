package kuang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo1 {
	public static void main(String[] args) {
		//ExecutorService threadPool = Executors.newSingleThreadExecutor();
		//ExecutorService threadPool= Executors.newFixedThreadPool(5);
		 ExecutorService threadPool= Executors.newCachedThreadPool();
		try {
			for(int i=0;i<12;i++) {
				threadPool.execute(()->{
					System.out.println(Thread.currentThread().getName());
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			threadPool.shutdown();
		}
	}

}
