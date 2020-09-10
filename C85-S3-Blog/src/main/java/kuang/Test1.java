package kuang;

public class Test1 {
	public static void main(String[] args) {
		Ticket t=new Ticket();
		//兰姆达表达式，并发编程，多个线程操作同一资源
		new Thread(()->{
			for(int i=0;i<40;i++) {
				t.sale();
			}
		},"A") .start();
		
		new Thread(()->{
			for(int i=0;i<40;i++) {
				t.sale();
			}
		},"B") .start();
	}

}
class Ticket{
	private int num=50;
	
	public synchronized void sale() {
		for(int i=0;i<50;i++) {
			if(num>0) {
				System.out.println(Thread.currentThread()+"买了"+num--+"剩余"+num);
			}
		}
	}
	
}
