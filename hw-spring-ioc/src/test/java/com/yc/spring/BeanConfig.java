package com.yc.spring;

import org.hamcrest.Factory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bbs.bean.User;

@Configuration
public class BeanConfig {
	
	@Bean("account")
	public  Account getAccount() {
		return new Account();
	}
	
	@Bean("account1")
	@Scope(value = "prototype")
	public  Account getAccount1() {
		return new Account();
	}
	
	@Bean(name="account2")
	public  Account getAccount2() {
		Account a=Account.getInstance();
		return a;
	}
	
	@Bean("account3")
	public  Account getAccount3() {
		Account a=Account.getInstance();
		return a;
	}

	@Bean("account4")
	@Scope(value = "prototype")
	public  Account getAccount4() {
		Account a=Account.getInstance();
		return a;
	}
	
	@Bean("myUser")
	public  User getUser() {
		User u=new User();
		u.setUname("武松");
		u.setUpass("abc123");
		u.setHead("20.gif");
		u.setGender(1);
		return u;
	}

}
