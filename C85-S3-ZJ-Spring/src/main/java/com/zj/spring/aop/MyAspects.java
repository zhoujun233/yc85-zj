package com.zj.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspects {
	@Pointcut(("execution(* com.zj.spring.dao.*Dao.select*(..))"))
	public void aspect1() {// 切点方法

	}

	@Before("aspect1()")
	// JoinPoint连接对象==>方法==>反射对象method
	// 接口注入JoinPoint对象
	public void before(JoinPoint jp) {
		jp.getArgs();// 方法参数
		jp.getSignature();// 方法签名
		System.out.println("======前置增强=======");
	}

	@After("aspect1()")
	public void after(JoinPoint jp) {
		System.out.println("======后置增强=======");
	}

	/**
	 * 
	 * @param jp
	 * @param ret
	 */
	@AfterReturning(value = "aspect1()", returning = "ret")
	public void afterReturning(JoinPoint jp, Object ret) {
		System.out.println("======返回增强==============" + ret + "=====");
	}

	/**
	 * throwing = "e" 表示业务产生异常，要注入到的方法参数的名称
	 * @param jp
	 * @param e
	 */
	@AfterThrowing(value = "aspect1()", throwing = "e")
	public void afterThrowing(JoinPoint jp, Exception e) {
		System.out.println("======异常增强===================" + e.getMessage() + "=======");
	}

	/**
	 * 环绕增强，执行方法需要自己来执行
	 */

	@Around("execution(* com.zj.spring.dao.Oracle*.*(..))")
	public Object around(ProceedingJoinPoint pjp) {
		System.out.println("========环绕增强==============");
		Object ret = null;
		try { // 调用业务方法 long
			long begin = System.currentTimeMillis();
			ret = pjp.proceed();
			long end = System.currentTimeMillis();
			System.out.println("一共消耗了" + ((end - begin) / 1000) + "秒");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return ret;
	}

}
