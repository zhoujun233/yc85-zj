package com.zj.C85S3Blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.Article;

public interface ArticleMapper {
	
	@Select("select * from article order by createtime desc")
	public List<Article> selectByNew();

}
