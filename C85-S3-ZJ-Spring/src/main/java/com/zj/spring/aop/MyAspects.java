package com.zj.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspects {
	@Pointcut(("execution(* com.zj.spring.dao.MySqlUserDao.*(..))"))
	public void aspect1(){//切点方法
		
	}
	@Before("aspect1()")
	public void before(){    
	System.out.println("======前置增强=======");   
		}


	}
