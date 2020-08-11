package com.zj.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.zj.spring.dao.MySqlUserDao;
import com.zj.spring.dao.OracleUserDao;

@Configuration    //表示这是一个注解配置
@ComponentScan("com.zj.spring")  //扫描该包和其所有子包
public class ConfigAnno {
	
	@Bean("hello")   //每一个方法对应xml里面的每一个bean
	public Hello getHello() {
		return new Hello();
	}
	
	/*
	 * @Bean("mdao") public MySqlUserDao getMySqlUserDao() { return new
	 * MySqlUserDao(); }
	 * 
	 * @Bean("odao") public OracleUserDao getOracleUserDao() { return new
	 * OracleUserDao(); }
	 */
	
	@Bean("p1")
	public Person getPerson1() {
		Person p1=new Person();
		p1.setName("武松");
		p1.setAge(35);
		p1.setKills(new ArrayList<String>());
		p1.getKills().add("潘金莲");
		p1.getKills().add("潘金莲");
		p1.getKills().add("潘金莲");
		p1.getKills().add("潘金莲");
		p1.setHeight(175);
		
		return p1;
	}
	
	@Bean("p5")
	public Person getPerson5() {
		Person p1=Person.PersonFactory();
		p1.setName("王英");
		return p1;
	}
	/**
	 * 原型模式
	 * @return
	 */
	@Bean("hello1")
	@Scope(value = "prototype")
	public Hello getHello1() {
		return new Hello();
	}

	/**
	 * 懒加载方法
	 */
	@Bean("hello2")
	@Lazy
	public Hello getHello2() {
		return new Hello();
	}
	
	/**
	 * 生命周期方法
	 */
	@Bean(name="hello3",initMethod = "init",destroyMethod = "destroy")
	public Hello getHello3() {
		return new Hello();
	}
	
	/**
	 * 自动装载方法
	 */
	@Bean(name="p8",autowire = Autowire.BY_NAME)
	public Person getPerson8() {
		Person p8=new Person();
		p8.setName("吴用");
		p8.setAge(40);
		return p8;
	}
	
	@Bean(name="friend")
	public Person getPerson9() {
		Person p8=new Person();
		p8.setName("林冲");
		return p8;
	}
	
}
