package com.zj.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zj.spring.dao.UserDao;


public class HelloTest {
	
	@Test
	public void test() {
		//创建spring容器对象
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Hello h=(Hello) ctx.getBean("hello");
		h.sayHello();
		ctx.close();
	}
	
	@Test
	public void test1() {
		//创建spring容器对象
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserDao udao1=(UserDao) ctx.getBean("mdao");
		UserDao udao2=(UserDao) ctx.getBean("odao");
		
		udao1.selectByUser("张三");
		udao2.selectByUser("张三");
		
		ctx.close();
	}

}
