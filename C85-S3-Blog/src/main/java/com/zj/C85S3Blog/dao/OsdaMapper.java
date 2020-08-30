package com.zj.C85S3Blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.Daysput;
import com.zj.C85S3Blog.bean.Osad;

public interface OsdaMapper {//每日一句，今日推荐
	
	@Select("select * from osad order by id desc limit 0,1")
	public Osad selectById();
	
	@Select("select * from daysput order by id desc limit 0,1")
	public Daysput selectByIds();
	
	@Insert("insert into osad values(null,#{statement},#{estatement},#{author},now())")
	public int inserto(Osad o);
	
	@Insert("insert into daysput values(null,#{title},#{content},#{url},now())")
	public int insertd(Daysput dp);

}
