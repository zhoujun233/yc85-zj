package kuang;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
	
	public static void main(String[] args) {
		//Set<String> set=Collections.synchronizedSet(new HashSet<>());
		Set<String> set=new CopyOnWriteArraySet<String>();
		for(int i=0;i<=100;i++) {
			new Thread(()->{
				set.add((String) UUID.randomUUID().toString().subSequence(0, 5));
				System.out.println(set);
			},String.valueOf(i)).start();
		}
	}

}
