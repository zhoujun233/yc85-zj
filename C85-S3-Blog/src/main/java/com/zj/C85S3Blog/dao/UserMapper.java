package com.zj.C85S3Blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.User;

public interface UserMapper {
	
	@Insert("insert into user values(null,#{name},#{account},#{pwd},#{phone},"
			+ "#{email},#{head},now(),#{status},#{type})")
	public void insert(User user);
	
	@Select("select * from user where account=#{account} and pwd=#{pwd}")
	public User selectByLogin(User user);
	
	@Select("select count(*) from user where account=#{account}")
	public int selectAccount(String account);
	
	@Select("select * from user where id=#{id}")
	public int selectById(int id);

}
