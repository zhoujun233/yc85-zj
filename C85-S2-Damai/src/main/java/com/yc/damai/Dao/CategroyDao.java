package com.yc.damai.Dao;

import java.util.List;

import com.yc.damai.util.DBHelper;

public class CategroyDao {
	public List<?> query() {
		return new DBHelper().query("select * from dm_category");
		
	}

}
