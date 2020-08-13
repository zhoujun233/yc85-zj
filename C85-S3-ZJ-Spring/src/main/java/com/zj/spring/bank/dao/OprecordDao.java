package com.zj.spring.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zj.spring.bank.bean.Oprecord;
@Repository
public class OprecordDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;// DBhelper

	public int insert(int id, double opmoney) {

		return jdbcTemplate.update("insert into oprecord values(null,?,?,null,now())", id, opmoney);

	}
	
	public List<Oprecord> selectByID(int accountid){
		String sql = "select * from oprecord where id=?";
		Object[] args = { accountid };
		return jdbcTemplate.query(sql, args,new RowMapper<Oprecord>() {

			@Override
			public Oprecord mapRow(ResultSet rs, int rowNum) throws SQLException {
				Oprecord op=new Oprecord();
				op.setId(rs.getInt("id"));
				op.setAccountid(rs.getInt("accountid"));
				op.setOpmoney(rs.getDouble("opmoney"));
				op.setCharge(rs.getDouble("charge"));
				op.setOptime(rs.getTimestamp("optime"));
				return op;
			}
			
		});
		
	}

}
