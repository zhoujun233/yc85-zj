package com.zj.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zj.spring.dao.UserDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AopConfig.class)
public class AopTest {
	
	@Autowired
	@Qualifier("mdao")//指定插入的组件的id
	private  UserDao mdao;
	@Autowired
	@Qualifier("odao")//指定插入的组件的id
	private  UserDao odao;
	@Autowired
	private  Hello hello;
	
	@Test
	public void test(){  
		System.out.println("==========");
		mdao.selectByUser("");
		System.out.println("==========");
		odao.selectByUser("");
		}
	
	@Test
	public void test1(){  
		System.out.println(mdao);//JDK
		System.out.println(odao);//JDK
		System.out.println(hello);//CGLIB
		}



}
