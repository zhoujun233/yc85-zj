package com.zj.spring.dao;

import org.springframework.stereotype.Repository;

import com.zj.spring.Person;

@Repository("odao")
public class OracleUserDao implements UserDao{

	public int selectByUser(String name) {
		System.out.println("oracle  userdao");
		 int i=3/0; 
		return 250;
	}

	@Override
	public int insert(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
