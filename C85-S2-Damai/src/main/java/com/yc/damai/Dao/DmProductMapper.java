package com.yc.damai.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmOrderitem;
import com.yc.damai.been.DmProduct;

public interface DmProductMapper {
	
	List<DmProduct> selectAll();
	
	DmProduct selectbyId(int id);
	
	List<DmProduct> selectbyObj(DmProduct dp);
	
	/**
	 * 
	 * @param cids用于给参数命名
	 * @return
	 */
	List<DmProduct> selectBycids(@Param("cids")int []cids);
	
	int update(DmProduct dp);

}
