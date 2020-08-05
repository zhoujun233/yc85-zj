package com.yc.damai.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmProduct;

public interface DmCategroyMapper {
	@Select("select * from dm_category")
	@Results({
		@Result(
				property = "listCategroy",
				column = "id",
				many=@Many(select = "selectChildren",fetchType = FetchType.LAZY))
	})
	List<DmCategory> selectAll();
	
	@Select("select * from dm_category where pid=#{id}")
	List<DmCategory> selectChildren();
	
	@Insert("insert into dm_category values(null,#{cname},#{pid})")
	int insert(DmCategory dc);
	
	@Update("update dm_category set cname=#{cname},pid=#{pid} where id=#{id}")
	int update(DmCategory dc);
	
	@Delete("delete from dm_category where id=#{id}")
	int delete(int id);

}
