package d0725_多线程;
/**
 * 龟兔赛跑
 * @author Administrator
 *
 */
public class Race implements Runnable{

	private  String winner;
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			if(end(i)) {
				break;
			}
			
				if(Thread.currentThread().getName().equals("兔子")) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
			
		}
		
	}
	
	//判断是否到达终点
	private boolean end(int staps) {
		if(winner!=null) {
			return true;
		}
		else if(staps>=99) {
			winner=Thread.currentThread().getName();
			System.out.println(Thread.currentThread().getName()+"赢了");
			return true;
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		Race r=new Race();
		new Thread(r,"兔子").start();
		new Thread(r,"乌龟").start();
		
	}

}
