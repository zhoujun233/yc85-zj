package com.zj.C85S3Blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.Article;

public interface ArticleMapper {
	
	@Select("select * from article order by createtime desc")
	@Results(id = "rmAm",value = {
			@Result(id=true,property = "id",column = "id"),
			@Result(property = "categoryid",column = "categoryid"),
			@Result(
					column = "categoryid",property = "category",
					one = @One(select="com.zj.C85S3Blog.dao.CategoryMapper.selectById")
					)
	})
	public List<Article> selectByNew();
	
	@Select("select * from article where id=#{id}")
	@ResultMap("rmAm")
	public Article selectById(int id);
	
	@Select("select * from article order by readcnt desc limit 0,5")
	public List<Article> selectByHot();
	
	@Insert("insert into article values (#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs},"
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
	public int insert(Article a);

}
