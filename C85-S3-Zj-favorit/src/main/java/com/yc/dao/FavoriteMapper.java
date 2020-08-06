package com.yc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.yc.bean.Favorite;

public interface FavoriteMapper {
	
	@Insert("insert into favorite value(null,#{flabel},#{furl},#{fdesc},#{ftages})")
	@Options(useGeneratedKeys = true,keyProperty = "fid",keyColumn = "fid")
	int insert(Favorite f);

}
