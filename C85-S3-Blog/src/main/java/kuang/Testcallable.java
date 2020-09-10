package kuang;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Testcallable {
	public static void main(String[] args) {
		MyThread thread =new MyThread();
		FutureTask ft=new FutureTask(thread);
		new Thread(ft).start();
		try {
			Integer o=(Integer)ft.get();
			System.out.println(o);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("call");
		return 123;
	}
	
}

