package com.yc.damai.Dao;

import java.util.List;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmOrderitem;
import com.yc.damai.been.DmProduct;

public interface DmOrderitemMapper {
	
	List<DmOrderitem> selectAll();
	
	DmOrderitem selectbyId(int id);

}
