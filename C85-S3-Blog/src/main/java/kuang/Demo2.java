package kuang;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

public class Demo2 {
	/**
	 * 
	 * @param args
	 */
	public static  void main(String[] args) {
		Consumer<String> consumer=(str)->{
			System.out.println(str);
		};
		consumer.accept("abc");
	}

}
