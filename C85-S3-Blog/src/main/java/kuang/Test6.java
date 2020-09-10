package kuang;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Test6 {
	public static void main(String[] args) {
		Mycache mc=new Mycache();
		//写
		for(int i=1;i<=5;i++) {
			final int a=i;
			new Thread(()->{
				mc.put("key",a);
				
			}) .start();
		}
		//读
		for(int i=1;i<=5;i++) {
			new Thread(()->{
				mc.get("key");
				
			}) .start();
		}
	}
}
class Mycache{
	private volatile Map<String,Object> map=new HashMap<>();
	//读写锁，更加精准的控制
	private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
	
	//写的时候只希望有一个锁写
	public void put(String key,Object value) {
		readWriteLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"开始写");
			map.put(key, value);
			System.out.println(Thread.currentThread().getName()+"写完");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			readWriteLock.writeLock().unlock();
		}
	}
	//读的时候只希望有多个线程读
		public void get(String key) {
			readWriteLock.readLock().lock();
			try {
				System.out.println(Thread.currentThread().getName()+"开始读");
				map.get(key);
				System.out.println(Thread.currentThread().getName()+"读完");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				readWriteLock.readLock().unlock();
			}
		}
}
