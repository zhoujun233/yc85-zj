package com.zj.spring.bank;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.spring.bank.dao.AccountDao;
import com.zj.spring.bank.dao.OprecordDao;
@Service
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
	public void save(int id,double money) {
		adao.update(id, money);
		int i=1/0;
		odao.insert(id, money);
	}
	//转账
	public void transfer(int id1,int id2,double money) {
		save(id1,money);
		save(id2,-money);
	}
	

}
