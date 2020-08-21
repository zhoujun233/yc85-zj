package com.zj.C85S3Springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zj.C85S3Springboot.bean.DmProduct;


public interface DmProductMapper {
	

	

	@Select("select * from dm_product where is_hot=1 limit 0,10")
	List<DmProduct> selectforHot();
	
	@Select("select * from dm_product order by id desc limit 0,10")
	List<DmProduct> selectforNew();

	
	

	@Select("select * from dm_product where id=#{id}")
	DmProduct selectById(int id);

}
