package com.yc.damai.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmProduct;

public class DmProductMapperTest {
	private SqlSession session;
	{
		// mybatis配置文件
		String resource = "mybatis.xml";
		// 读入配置文件
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			// 构建会话工厂==》23设计模式 工厂模式
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 打开会话
			session = sqlSessionFactory.openSession();
			// session.selectList(XML命名空间+英文点号+查询SQL的id)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 测试方法加注解

	@Test public void test1() throws IOException { List<DmProduct> list =
	  session.selectList("com.yc.damai.Dao.DmProductMapper.selectAll"); 
	// true 期望值 list.size()>0实际值
	  Assert.assertEquals(true, list.size() > 0); }

	@Test
	public void test2() throws IOException {
		DmCategory dc = new DmCategory();
		dc.setCname("测试分类");
		dc.setPid(1);
		session.insert("com.yc.damai.Dao.DmProductMapper.insert", dc);
		session.commit();
	}

	@Test
	public void test3() throws IOException {
		DmCategory dc = new DmCategory();
		dc.setCname("修改后的测试分类");
		dc.setPid(1);
		dc.setId(44);
		session.update("com.yc.damai.Dao.DmProductMapper.update", dc);
		session.commit();
	}

	@Test
	public void test4() throws IOException {
		DmCategory dc = new DmCategory();
		dc.setCname("修改后的测试分类");
		dc.setPid(1);
		dc.setId(44);
		session.delete("com.yc.damai.Dao.DmProductMapper.delete", dc);
		session.commit();
	}

	@Test
	public void insert() throws IOException {
		DmProduct dp = new DmProduct();
		dp.setPname("测试");
		dp.setMarketPrice(250.0);
		dp.setShopPrice(125.0);
		dp.setImage("xxxxxx");
		dp.setPdesc("村上春树");
		dp.setIsHot(1);
		dp.setCid(1);
		session.insert("com.yc.damai.Dao.DmProductMapper.insertproduct", dp);
		session.commit();
	}

	@Test
	public void queryid() throws IOException {
		DmProduct dp = new DmProduct();
		dp.setId(72);
		List<DmProduct> list = session.selectList("com.yc.damai.Dao.DmProductMapper.selectproduct", dp);
		Assert.assertEquals(true, list.size() == 1);
	}

	@Test
	public void update() throws IOException {
		DmProduct dp = new DmProduct();
		dp.setPname("测试");
		dp.setMarketPrice(110.0);
		dp.setShopPrice(125.0);
		dp.setId(73);
		session.update("com.yc.damai.Dao.DmProductMapper.updateproduct", dp);
		session.commit();
	}

	@Test
	public void delete() throws IOException {
		DmProduct dp = new DmProduct();
		dp.setId(73);
		session.delete("com.yc.damai.Dao.DmProductMapper.deleteproduct", dp);
		session.commit();
	}

}
