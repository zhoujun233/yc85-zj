package com.yc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import com.yc.bean.Favorite;

public interface FavoriteMapper {
	
	@Insert("insert into favorite value(null,#{flabel},#{furl},#{fdesc},#{ftages})")
	@Options(useGeneratedKeys = true,keyProperty = "fid",keyColumn = "fid")
	int insert(Favorite f);
	
	int update(Favorite f);
	
	List<Favorite> selectByTid(@Param("tid")Integer tid);

}
