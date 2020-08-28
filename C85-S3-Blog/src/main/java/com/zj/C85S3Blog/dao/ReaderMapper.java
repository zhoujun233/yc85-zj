package com.zj.C85S3Blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.User;

public interface ReaderMapper {
	
	@Select("select * from user where type=#{type} order by commits desc limit 0,3")
	public List<User>selectByType(User user);

}
