package com.zj.spring.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.zj.spring.bank.bean.Account;

@Repository
public class AccountDao {

	@Resource
	private JdbcTemplate jdbcTemplate;// DBhelper

	public int insert(int id,String pwd, double balance) {

		return jdbcTemplate.update("insert into account values(?,?,?)",id, pwd, balance);

	}

	public int update(int id, double balance) {

		return jdbcTemplate.update("update account set balance=balance+? where accountid=?", balance, id);

	}

	public Account selectById(int id) {
		String sql = "select * from account where accountid=?";
		Object[] args = { id };
		return jdbcTemplate.query(sql, args, new ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				Account acc = new Account();
				acc.setAccountid(rs.getInt("accountid"));
				acc.setPassword(rs.getString("password"));
				acc.setBalance(rs.getDouble("balance"));
				return acc;
			}

		});

	}

}
