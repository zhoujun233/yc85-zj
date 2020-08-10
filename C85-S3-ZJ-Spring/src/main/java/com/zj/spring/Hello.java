package com.zj.spring;

public class Hello {
	
	public Hello() {
		System.out.println("======无参数的构造方法=======");
	}
	
	public Hello(int a) {
		System.out.println("======有参数的构造方法=======");
	}
	
	public void sayHello() {
		System.out.println("你好");
	}
	
	public void init() {
		System.out.println("=======Hello被创建=========");
	}
	
	public void destroy() {
		System.out.println("=======Hello被销毁=========");
	}

}
