package com.zj.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.annotations.Insert;

import com.zj.spring.Person;
import com.zj.spring.dao.UserDao;

public class SqlSession {
	
	
	public static void main(String[] args) {
		SqlSession session=new SqlSession();
		UserDao udao=session.getMapper(UserDao.class);
		udao.insert(new Person());
	}
	
	public <M> M getMapper(Class<M> cls){
		@SuppressWarnings("unchecked")
		M ret=(M) Proxy.newProxyInstance(cls.getClassLoader(), 
				new Class[] {cls}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy,
							Method method, 
							Object[] args) throws Throwable {
						Insert insert=method.getAnnotation(Insert.class);
						if(insert!=null) {
							//使用Dbhelper执行语句
							System.out.println("执行"+insert.value());
							if(method.getReturnType()!=null) {
								if(method.getReturnType().equals(Insert.class)) {
									//如果返回的是Integer类型，返回Integer值
								}
							}
						}
						
						return null;
					}
				});
		
		
		return ret;
		
	}

}
