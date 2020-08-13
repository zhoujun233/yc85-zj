package com.zj.spring;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zj.spring.bank.BankBiz;

@RunWith(SpringRunner.class)
@ContextConfiguration("/jdbc.xml")
public class JdbcTest {
	
	@Resource
	private JdbcTemplate jdbcTemplate;//DBhelper
	@Resource
	private BankBiz bbiz;
	
	
	@Test
	public void test1() {
		jdbcTemplate.update("insert into account values(1,'a',1000)");
	}
	
	@Test
	public void test2() {
		bbiz.resiget(2, "acb", 2000);
	}
	
	@Test
	public void test3() {
		bbiz.transfer(1, 2, 300);
	}
	
	@Test
	public void test4() {
		bbiz.save(1, 1000);
	}
	

}
