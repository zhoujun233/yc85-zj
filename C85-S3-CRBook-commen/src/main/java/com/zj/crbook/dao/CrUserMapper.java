package com.zj.crbook.dao;

import com.zj.crbook.bean.CrUser;
import com.zj.crbook.bean.CrUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrUserMapper {
    long countByExample(CrUserExample example);

    int deleteByExample(CrUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrUser record);

    int insertSelective(CrUser record);

    List<CrUser> selectByExample(CrUserExample example);

    CrUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrUser record, @Param("example") CrUserExample example);

    int updateByExample(@Param("record") CrUser record, @Param("example") CrUserExample example);

    int updateByPrimaryKeySelective(CrUser record);

    int updateByPrimaryKey(CrUser record);
}