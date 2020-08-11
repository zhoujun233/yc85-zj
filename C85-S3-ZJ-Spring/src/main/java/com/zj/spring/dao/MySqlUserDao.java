package com.zj.spring.dao;

import org.springframework.stereotype.Repository;
/**
 * 注解方式的自动装配
 * @author Administrator
 *
 */

@Repository("mdao")
public class MySqlUserDao implements UserDao{

	public int selectByUser(String name) {
		System.out.println("mysql  userdao");
		return 0;
	}
	
	

}
