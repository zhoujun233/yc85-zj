package com.yc.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHelper {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		// mybatis配置文件
		String resource = "mybatis.xml";
		// 读入配置文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			// 构建会话工厂==》23设计模式 工厂模式
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			// session.selectList(XML命名空间+英文点号+查询SQL的id)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  static SqlSession openSession() {
		return  sqlSessionFactory.openSession();
	}

}
