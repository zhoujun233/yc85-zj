package com.zj.C85S3Springboot.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.C85S3Springboot.bean.DmUser;

@Service
public class UserBiz {
	
	@Resource
	private Userdao udao;
	
     public DmUser Login(String name,String pwd) throws BizException {
    	 
    	 DmUser user=udao.selectByUser(name, pwd);
    	 
    	 if(user==null) {
    		 throw new BizException("用户名或密码错误");
    	 }
    	 return user;
    	
     }

}
