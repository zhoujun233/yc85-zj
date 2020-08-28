package com.zj.C85S3Blog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.dao.UserMapper;

@Service
public class UserBiz {

	@Resource
	private UserMapper umapper;

	public void register(User user) throws BizException {
		// 可以忽略字段验证 数据校验
		// 同名验证
		if (umapper.selectAccount(user.getAccount()) > 0) {
			throw new BizException("该用户名已存在");
		}
		 user.setType("普通读者"); 
		umapper.add(user);

	}

	public User Login(User user) throws BizException {

		User duser = umapper.selectByLogin(user);

		if (duser == null) {
			throw new BizException("用户名或密码错误");
		}
		return duser;

	}

}
