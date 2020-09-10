package kuang;
/**
 * 生产者消费者模式
 * @author Administrator
 *
 */
public class Test3 {
	public static void main(String[] args) {
		PC p =new PC();
		new Thread(()->{try {
			p.incr();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}},"A") .start();
		
		new Thread(()->{try {
			p.desc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}},"B") .start();
		
		new Thread(()->{try {
			p.incr();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}},"C") .start();
		
		
		new Thread(()->{try {
			p.desc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}},"D") .start();
	}
}

class PC{
	private int producr=0;
	
	public synchronized void incr() throws InterruptedException {
		for(int i=0;i<40;i++) {
			while(producr!=0) {//如果不将if改为while会产生虚假唤醒问题
				this.wait();
			}
			producr++;
			this.notify();
			System.out.println(Thread.currentThread().getName()+"===="+producr);
		}
	}
	
	public synchronized void desc() throws InterruptedException {
		for(int i=0;i<40;i++) {
			while(producr==0) {
			this.wait();
		}
		producr--;
		System.out.println(Thread.currentThread().getName()+"===="+producr);
		this.notify();
		}
	}
}
