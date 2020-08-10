package com.zj.spring;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zj.spring.dao.UserDao;

public class HelloTestByAnno {
	
	private AnnotationConfigApplicationContext ctx;

	@Before
	public void before() {
		ctx = new AnnotationConfigApplicationContext(ConfigAnno.class);
	}

	@After
	public void after() {
		ctx.close();
	}
	
	@Test
	public void test() {
		// 创建spring对象
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Hello h = (Hello) ctx.getBean("hello");
		h.sayHello();
		ctx.close();
	}

	@Test
	public void test1() {
		/**
		 * Spring框架解决的问题 Servlet Usebiz usb=new Usebiz(); Usebiz usb=new subUsebiz1();
		 * Usebiz usb=new subUsebiz2(); 1.new=>创建对象=>内存中占用存储对象的空间 每次new都会创建一个新的对象
		 * ==>内存消耗大 2.耦合性问题 对象可以任意在运行期设置为子类的现实类 3. 控制反转 对象创建由程序员决定 对象的创建由容器决定
		 * 
		 */

		// ����spring��������
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserDao udao1 = (UserDao) ctx.getBean("mdao");
		UserDao udao2 = (UserDao) ctx.getBean("odao");

		udao1.selectByUser("张三");
		udao2.selectByUser("张三");

		ctx.close();
	}

	@Test
	public void test2() {
		Person p1 = (Person) ctx.getBean("p1");
		Assert.assertEquals(4, p1.getKills().size());
		System.out.println(p1.getKills());
		Assert.assertEquals("潘金莲", p1.getKills().get(0));
		Assert.assertEquals("武松", p1.getName());
		Assert.assertEquals(35, p1.getAge());
		Assert.assertEquals(175, p1.getHeight());
	}

	@Test
	public void test3() {
		Person p1 = ctx.getBean(Person.class);
		Assert.assertEquals("李逵", p1.getName());
		Assert.assertEquals(40, p1.getAge());
		Assert.assertEquals("黑旋风", p1.getAlisa());
	}

	@Test
	public void test4() {
		Person p1 = (Person) ctx.getBean("p2");
		Assert.assertEquals("吴用", p1.getName());
		Assert.assertEquals(40, p1.getAge());
		Assert.assertEquals("林冲", p1.getFriend().getName());
		Assert.assertEquals(36, p1.getFriend().getAge());
	}

	@Test
	public void test5() {
		Person p1 = (Person) ctx.getBean("p3");
		Assert.assertEquals("吴用", p1.getName());
		Assert.assertEquals(40, p1.getAge());
		Assert.assertEquals("林冲", p1.getFriend().getName());
		Assert.assertEquals(36, p1.getFriend().getAge());
	}

	@Test
	public void test6() {
		Person p1 = (Person) ctx.getBean("p5");
		Assert.assertEquals("王英", p1.getName());
		Assert.assertEquals(40, p1.getAge());
	}

	@Test
	public void test7() {
		Person p1 = (Person) ctx.getBean("p6");
		Assert.assertEquals("郭嘉", p1.getName());
		Assert.assertEquals(20, p1.getAge());
	}

	@Test
	public void test8() {
		Hello h0 = (Hello) ctx.getBean("hello");
		Hello h0_1 = (Hello) ctx.getBean("hello");
		Hello h0_2 = (Hello) ctx.getBean("hello");

		Hello h1 = (Hello) ctx.getBean("hello1");
		Hello h1_1 = (Hello) ctx.getBean("hello1");
		Hello h1_2 = (Hello) ctx.getBean("hello1");

		System.out.println(h0_1 == h0);// true
		System.out.println(h0 == h1);// false
		System.out.println(h1_1 == h1);// false

	}

	/**
	 * 懒加载方法
	 */
	@Test
	public void test9() {
		System.out.println("==========test=========");
		Hello h0 = (Hello) ctx.getBean("hello2");
		h0.sayHello();
	}

	/**
	 * 生命周期方法
	 */
	@Test
	public void test10() {
		System.out.println("==========test=========");
		Hello h0 = (Hello) ctx.getBean("hello3");
	}

	/**
	 * 自动装载方法
	 */
	@Test
	public void test11() {
		Person p8 = (Person) ctx.getBean("p8");
		System.out.println(p8.getFriend().getName());
	}


}
