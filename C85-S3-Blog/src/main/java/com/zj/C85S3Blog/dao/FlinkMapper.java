package com.zj.C85S3Blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Blog.bean.Flink;

public interface FlinkMapper {
	
	@Select("select * from flink where userid=#{userid}")
	public List<Flink> selectAll(int id);
	
	@Insert("insert into flink values(null,#{name},#{url},1,#{description},1,1,#{userid})")
	public int insert(Flink f);

}
