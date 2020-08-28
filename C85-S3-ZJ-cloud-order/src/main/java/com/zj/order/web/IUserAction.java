package com.zj.order.web;

import org.springframework.stereotype.Component;

@Component
//为什么这个Action不用@Controller  因为这不是用户直接使用的Action，只是一个替代方案
public class IUserAction implements IUuserAction{

	@Override
	public String user() {
		
		return "声明式服务降级方法";
	}
	

}
