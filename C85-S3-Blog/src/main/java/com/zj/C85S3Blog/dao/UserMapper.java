package com.zj.C85S3Blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zj.C85S3Blog.bean.User;

public interface UserMapper {

	@Insert("insert into user values(null,#{name},#{account},#{pwd},#{phone},"
			+ "#{email},#{head},now(),0,#{type})")
	public void add(User user);

	@Select("select * from user where account=#{account} and pwd=#{pwd}")
	public User selectByLogin(User user);

	@Select("select count(*) from user where account=#{account}")
	public int selectAccount(String account);

	@Select("select * from user where id=#{id}")
	public User selectById(User user);

	@Update("update user set commits=commits+1 where id=#{id} ")
	public void updateById(User user);

	@Update("update user set type=#{type} where id=#{id} ")
	public void updateById1(User user);
	
	@Select("select * from user where id=#{id}")
	public User selectById1(int id);
	
	@Update("update user set head=#{head} where id=#{id} ")
	public void updatehead(String head,int id);
	
	@Update("update user set pwd=#{pwd} where account=#{account} ")
	public void updatepwd(String pwd,String account);

}
