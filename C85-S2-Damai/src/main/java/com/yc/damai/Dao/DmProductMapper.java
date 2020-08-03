package com.yc.damai.Dao;

import java.util.List;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmOrderitem;
import com.yc.damai.been.DmProduct;

public interface DmProductMapper {
	
	List<DmProduct> selectAll();
	
	DmProduct selectbyId(int id);

}
