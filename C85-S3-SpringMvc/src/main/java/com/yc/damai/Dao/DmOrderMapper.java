package com.yc.damai.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmOrderitem;
import com.yc.damai.been.DmOrders;
import com.yc.damai.been.DmProduct;

public interface DmOrderMapper {
	
	@Insert("insert into dm_orders values(null,#{total},now(),#{state},#{uid},#{aid})")
	@Options(useGeneratedKeys=true,keyProperty="id", keyColumn="id")
	int insert(DmOrders dos);
	
	DmOrders selectbyId(int id);

}
