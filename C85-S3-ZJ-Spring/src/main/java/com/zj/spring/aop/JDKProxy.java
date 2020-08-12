package com.zj.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * 
 * @author Administrator
 *
 */
public class JDKProxy implements InvocationHandler {
	public static void main(String[] args) {
		JDKProxy jp = new JDKProxy();
		RealSubject rs = new RealSubject();
		// 对应ProxySubject ps=new ProxySubject();
		Subject ps = (Subject) jp.createProxyInstance(rs);
		ps.say();

		HouseOwner ho = new HouseOwner();
		Broker bk = (Broker) jp.createProxyInstance(ho);
		bk.sale();
	}

	// 被代理对象
	private Object realSubject;

	/**
	 * 
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 前置增强
		System.out.println("我的被告人有不在场证明");
		Object ret = method.invoke(realSubject, args);
		// 后置增强
		System.out.println("我的被告人有不在场证明");
		return ret;
	}

	public Object createProxyInstance(Object targerObject) {
		this.realSubject = targerObject;

		return Proxy.newProxyInstance(targerObject.getClass().getClassLoader(),
				targerObject.getClass().getInterfaces(),
				this);

	}

}

interface Broker {
	void sale();
}

//真实主题：被告
class HouseOwner implements Broker {

	@Override
	public void sale() {
		System.out.println("房子又大又好看");

	}

}
