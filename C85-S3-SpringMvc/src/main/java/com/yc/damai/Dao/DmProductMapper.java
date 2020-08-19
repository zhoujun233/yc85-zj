package com.yc.damai.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmOrderitem;
import com.yc.damai.been.DmProduct;

public interface DmProductMapper {
	@Select("select * from dm_product ")
	//@Results替代<resultMap>标签   @Result替代<result>标签
	@Results(id = "rmdp", value = { @Result(column = "id", property = "id", id = true),
			@Result(column = "market_price", property = "marketPrice"),
			@Result(column = "shop_price", property = "shopPrice"), @Result(column = "is_hot", property = "isHot"), })
	List<DmProduct> selectAll();

	@Select("select * from dm_product where id=#{id}")
	//@ResultMap替代<select>标签中的ResultMap属性
	@ResultMap("rmdp")
	DmProduct selectbyId(int id);

	List<DmProduct> selectbyObj(DmProduct dp);

	/**
	 * 
	 * @param cids用于给参数命名
	 * @return
	 */
	List<DmProduct> selectBycids(@Param("cids") int[] cids);

	int update(DmProduct dp);

}
