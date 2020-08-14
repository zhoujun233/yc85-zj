package com.zj.spring.bank;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zj.spring.bank.dao.AccountDao;
import com.zj.spring.bank.dao.OprecordDao;
@Service
@Transactional(rollbackFor = {BankException.class,SQLException.class})
public class BankBiz {
	@Resource
	private AccountDao adao;
	@Resource
	private OprecordDao odao;
	
	//注册
	public void resiget(int id,String pwd,double money) {
		adao.insert(id,pwd, money);
		odao.insert(id, money);
	}
	//存取款
	@Transactional(rollbackFor = {BankException.class})
	public void save(int id,double money) throws BankException {
		adao.update(id, money);
	   /*try {*/
			if(money>999) {
				throw new BankException("存取金额不能大于999");
			}
		/*
		 * }catch(BankException e) { //throw new
		 * 将编译期异常转为运行期异常
		 * DataAccessResourceFailureException("",e); }
		 */
		odao.insert(id, money);
	}
	//转账
	public void transfer(int id1,int id2,double money) throws BankException {
		save(id1,money);
		save(id2,-money);
	}
	

}
