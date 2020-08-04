package com.yc.damai.Dao;

import java.util.List;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmProduct;

public interface DmCategroyMapper {
	
	List<DmCategory> selectAll();
	
	List<DmCategory> selectChildren();
	
	int insert(DmCategory dc);
	
	int update(DmCategory dc);
	
	int delete(int id);

}
