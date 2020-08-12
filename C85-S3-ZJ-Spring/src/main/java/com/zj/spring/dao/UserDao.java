package com.zj.spring.dao;

import org.apache.ibatis.annotations.Insert;

import com.zj.spring.Person;

public interface UserDao {
	
	public int selectByUser(String name);
	
	@Insert("insert into Person values(#{pname})")
	int insert(Person p) ;

}
