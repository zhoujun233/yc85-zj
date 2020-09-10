package kuang;

import java.util.concurrent.TimeUnit;
/**
 * 8锁问题
 * @author Administrator
 *
 */
public class Test {

}

class Phone {
	
	public void sendSms() {
		try {
			TimeUnit.SECONDS.sleep(1);//休息一秒
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("发短信");
	}
	
    public void call() {
    	System.out.println("打电话");
	}
}
