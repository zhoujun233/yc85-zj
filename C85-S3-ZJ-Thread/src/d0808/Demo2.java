package d0808;

import java.lang.reflect.Method;

@Test("测试类")
public class Demo2 {
	@Test("测试方法")
	public void test() {
		
	}
	
	public static void main(String[] args) throws 
	ClassNotFoundException, NoSuchMethodException,
	SecurityException//安全异常（不允许获取）
	{
		Demo2 d=new Demo2();
		//反射
		//获取一个类的类对象
		//1
		Class<?> cls=Demo2.class;
		//2
		cls=d.getClass();
		//3
		cls=Class.forName("d0808.Demo2");
		
		//反射操作
		cls.getFields();//获取公有的属性数组
		cls.getMethods();//获取公有的方法数组
		cls.getConstructors();//获取公有的构造方法数组
		cls.getAnnotations();//获取类上注解数组
		Test test1=cls.getAnnotation(Test.class);
		//如果为null，说明没找到对应注解
		System.out.println(test1.value());
		//获取方法对象
		Method m=cls.getMethod("test");
		Test test2=m.getAnnotation(Test.class);
		System.out.println(test2.value());
		
	}

}
