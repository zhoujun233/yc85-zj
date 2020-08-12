package com.zj.spring.dao;

import org.springframework.stereotype.Repository;
/**
 * 注解方式的自动装配
 * @author Administrator
 *@Component   通用的组件注解
 *@Controller  控制器组件注解 ===>相当于Servlet
 *@Service     服务类组件注解===>xxxBiz,xxxService
 *@Repository  dao类组件注解===>xxxDao,xxxMapper
 */

@Repository("mdao")
public class MySqlUserDao implements UserDao{

	public int selectByUser(String name) {
		System.out.println("mysql  userdao");
		return 100;
	}
	
	

}
