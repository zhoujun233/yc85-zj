package com.yc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;

public interface TagMapper {
	
	@Insert("insert into tag value(null,#{tname},#{tcount})")
	@Options(useGeneratedKeys = true,keyProperty = "tid",keyColumn = "tid")
	int insert(Tag t);

}
