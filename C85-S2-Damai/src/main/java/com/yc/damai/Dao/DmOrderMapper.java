package com.yc.damai.Dao;

import java.util.List;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmOrderitem;
import com.yc.damai.been.DmOrders;
import com.yc.damai.been.DmProduct;

public interface DmOrderMapper {
	
	int insert(DmOrders dos);
	
	DmOrders selectbyId(int id);

}
