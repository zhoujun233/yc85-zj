package kuang;

import java.util.concurrent.TimeUnit;

public class Demo3 {
	//验证了volatile的可见性
	//不加volatile程序会进入死循环
	private static volatile int num=0;
	
	public static void main(String[] args) {
		new Thread(()->{
			while(num==0) {
				
			}
		}) .start();
		
		
		try {
			TimeUnit.SECONDS.sleep(3);
		}catch(Exception e) {
			e.printStackTrace();
		}
		num=1;
		System.out.println(num);
	}

}
