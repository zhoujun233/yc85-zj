package com.zj.spring.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * CGLIB代理
 * @author Administrator
 *
 */
public class CGLIBProxy implements MethodInterceptor{
	
	public static void main(String[] args) {
		RealSubject rs=new RealSubject();
		HouseOwner ho=new HouseOwner();
		CGLIBProxy cp=new CGLIBProxy();
		RealSubject cps=(RealSubject) cp.proxy(rs);
		cps.say();
		HouseOwner hos=(HouseOwner) cp.proxy(ho);
		hos.sale();
	}
	
	// 被代理对象
	private Object realSubject;
	
	public Object intercept(Object obj,//目标对象的实例
			Method method,//父类方法的Method实例
			Object[] args,//传到代理实例上方法的参数组
			MethodProxy methodProxy) throws Throwable {
		System.out.println("代理类"+obj.getClass());
		System.out.println("方法名称"+method.getName());
		if(args!=null&&args.length>0) {
			for(int i=0;i<args.length;i++) {
				System.out.println("方法参数"+args[i]);
			}
		}
		Object returnvalue=null;//方法的返回值，无返回时为null
		returnvalue=methodProxy.invoke(this.realSubject, args);
		System.out.println("方法的返回值"+returnvalue);
		return returnvalue;
		}
	/**
	 * 代理方法
	 */
	public Object proxy(Object targetObject) {
		this.realSubject=targetObject;
		Enhancer enhancer=new Enhancer();//该类生成代理对象
		enhancer.setSuperclass(targetObject.getClass());//设置父类
		enhancer.setCallback( this);//设置回调对象为本身
		return enhancer.create();
		
	}

}
