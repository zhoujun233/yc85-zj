package kuang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import net.sf.jsqlparser.expression.KeepExpression;


public class Demo1 {
	public static void main(String[] args) {
		//获取CPU核数
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		 ExecutorService threadPool= new ThreadPoolExecutor(
				 2,//一开始线程池容量
				 Runtime.getRuntime().availableProcessors(),//最大线程池容量
				 3, TimeUnit.SECONDS,//超时时间
				 new LinkedBlockingQueue<Runnable>(3),//最多可等待的线程
				 Executors.defaultThreadFactory(),//创建线程
				 new ThreadPoolExecutor.AbortPolicy()//拒绝策略
				 );
		try {
			for(int i=1;i<=4;i++) {
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
