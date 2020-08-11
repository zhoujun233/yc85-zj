package com.zj.spring.dao;

import org.springframework.stereotype.Repository;

@Repository("odao")
public class OracleUserDao implements UserDao{

	public int selectByUser(String name) {
		System.out.println("oracle  userdao");
		return 0;
	}
	
	

}
