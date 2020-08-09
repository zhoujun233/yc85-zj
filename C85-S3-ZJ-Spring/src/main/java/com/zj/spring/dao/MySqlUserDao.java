package com.zj.spring.dao;

public class MySqlUserDao implements UserDao{

	public int selectByUser(String name) {
		System.out.println("mysql  userdao");
		return 0;
	}
	
	

}
