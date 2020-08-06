package com.yc.dao;

import org.apache.ibatis.annotations.Insert;

import com.yc.bean.TagFavorite;

public interface TagFacoriteMapper {
	
	@Insert("insert into tagfavorite value(#{tid},#{fid})")
	int insert(TagFavorite tf);
	
	int update(TagFavorite tf);

}
