package com.zj.C85S3Blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.Comment;

public interface CommentMapper {
	
	@Insert("insert into comment values(#{id},#{articleid},#{content},#{createby},now())")
	public int insert(Comment comment);
	
	@Select("select * from comment where articleid=#{articleid}")
	public List<Comment> select(int articleid);

}
