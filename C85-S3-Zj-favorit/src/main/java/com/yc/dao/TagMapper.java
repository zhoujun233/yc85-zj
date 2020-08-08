package com.yc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yc.bean.Tag;

public interface TagMapper {
	
	@Insert("insert into tag value(null,#{tname},1)")
	@Options(useGeneratedKeys = true,keyProperty = "tid",keyColumn = "tid")
	int insert(Tag t);
	
	@Update("update tag set tcount=tcount+1 where tname=#{tname}")
	int updateCount(String t);
	
	@Select("select * from tag where tname=#{tname}")
	Tag selectByName(String tag);
	
	@Select("select * from tag ")
	List<Tag> selectAll();
	
	

}
