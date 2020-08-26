package com.zj.C85S3Blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.Comment;

public interface CommentMapper {
	
	@Insert("insert into comment values(#{id},#{articleid},#{content},#{createby},now())")
	public int insert(Comment comment);
	
	@Select("select * from comment where articleid=#{articleid}")
	@Results(id="rmCm",value = {
			@Result(id=true,property = "id",column = "id"),
			@Result(property = "createby",column = "createby"),
			@Result(property = "user",column = "createby",
			one=@One(select = "com.zj.C85S3Blog.dao.UserMapper.selectById"))
	})
	public List<Comment> select(int articleid);

}
