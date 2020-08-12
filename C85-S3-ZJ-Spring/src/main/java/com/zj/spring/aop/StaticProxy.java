package com.zj.spring.aop;

public class StaticProxy {
	public static void main(String[] args) {
		ProxySubject ps=new ProxySubject();
		ps.say();
	}

}
//主题
interface Subject {
	void say();
}
//真实主题：被告
class RealSubject implements Subject {
	@Override
	public void say() {
		System.out.println("真的不是我干的");
		
	}
	
}
//代理主题：律师
class ProxySubject implements Subject {
	//被代理对象：被告
	RealSubject rs=new RealSubject();
	@Override
	public void say() {
		//前置增强
		System.out.println("我的被告人有不在场证明");
		rs.say();
		//后置增强
		System.out.println("我的被告人有不在场证明");
		
	}
	
}
