package com.zj.C85S3Blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.Category;

public interface CategoryMapper {
	
	@Select("select * from category")
	public List<Category> selectAll();

}
