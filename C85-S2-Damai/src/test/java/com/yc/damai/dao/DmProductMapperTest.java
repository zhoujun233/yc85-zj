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

import com.yc.damai.Dao.DmCategroyMapper;
import com.yc.damai.Dao.DmOrderMapper;
import com.yc.damai.Dao.DmOrderitemMapper;
import com.yc.damai.Dao.DmProductMapper;
import com.yc.damai.been.DmCategory;
import com.yc.damai.been.DmOrderitem;
import com.yc.damai.been.DmOrders;
import com.yc.damai.been.DmProduct;

public class DmProductMapperTest {
	private SqlSession session;
	private SqlSession session2;
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
			session2 = sqlSessionFactory.openSession();
			// session.selectList(XML命名空间+英文点号+查询SQL的id)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 测试方法加注解

	@Test
	public void test1() throws IOException {
		List<DmProduct> list = session.selectList("com.yc.damai.Dao.DmProductMapper.selectAll");
		// true 期望值 list.size()>0实际值
		Assert.assertEquals(true, list.size() > 0);

		/*
		 * for (DmProduct dp : list) { System.out.println(dp); }
		 */

	}

	@Test
	public void test2() throws IOException {
		DmCategory dc = new DmCategory();
		dc.setCname("测试分类");
		dc.setPid(1);
		DmCategroyMapper mapper = session.getMapper(DmCategroyMapper.class);
		mapper.insert(dc);
		/* session.insert("com.yc.damai.Dao.DmProductMapper.insert", dc); */
		session.commit();
		session.close();
	}

	@Test
	public void test3() throws IOException {
		DmCategory dc = new DmCategory();
		dc.setCname("修改后的测试分类");
		dc.setPid(1);
		dc.setId(61);
		/* session.update("com.yc.damai.Dao.DmProductMapper.update", dc); */
		DmCategroyMapper mapper = session.getMapper(DmCategroyMapper.class);
		mapper.update(dc);
		session.commit();
		session.close();
	}

	@Test
	public void test4() throws IOException {
		DmCategory dc = new DmCategory();
		dc.setCname("修改后的测试分类");
		dc.setPid(1);
		dc.setId(44);
		/* session.delete("com.yc.damai.Dao.DmProductMapper.delete", dc); */
		DmCategroyMapper mapper = session.getMapper(DmCategroyMapper.class);
		mapper.delete(61);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5() throws IOException {
		/**
		 * 关联查询   订单详情表与商品表
		 */
		/*
		 * DmOrderitemMapper dom=session.getMapper(DmOrderitemMapper.class);
		 * DmProductMapper dpm=session.getMapper(DmProductMapper.class); DmOrderitem
		 * doi=dom.selectbyId(59); DmProduct dp=dpm.selectbyId(doi.getPid());
		 */
		DmOrderitemMapper dom=session.getMapper(DmOrderitemMapper.class);
		DmOrderitem doi=dom.selectbyId(59);
		DmProduct dp=doi.getDmPorduct();
		System.out.println(dp);
		
		session.close();
	}
	@Test
	public void test6() throws IOException {
			/**
			 * 一对多关联	
			 */
		DmOrderMapper dom=session.getMapper(DmOrderMapper.class);
		DmOrders doi=dom.selectbyId(69);
		List<DmOrderitem> dos=doi.getList();
		System.out.println(dos);
		session.close();
	}
	
	@Test
	public void test7() throws IOException {
			/**
			 * 一对多关联	
			 */
		DmCategroyMapper mapper=session.getMapper(DmCategroyMapper.class);
		
		List<DmCategory> dclist=mapper.selectAll();
		System.out.println("=======1========");
		DmCategory dc=dclist.get(1);
		System.out.println("========2=======");
		Assert.assertEquals("鞋靴箱包", dc.getCname());
		System.out.println("=======3========");
		Assert.assertEquals(6, dc.getListCategroy().size());
		System.out.println("=======4========");
	}
	
	@Test
	public void test8() throws IOException {
			/**
			 * 组合查询
			 */
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		DmProduct dp=new DmProduct();
		System.out.println("======1========");
		mapper.selectbyObj(dp);
		System.out.println("=======2=======");
		mapper.selectbyObj(null);
		System.out.println("=======3=======");
		dp.setPname("测试名字");
		mapper.selectbyObj(dp);
		System.out.println("=======4=======");
		dp.setPdesc("测试描述");
		mapper.selectbyObj(dp);
		System.out.println("========5======");
		dp.setIsHot(-1);
		mapper.selectbyObj(dp);
		System.out.println("=======6=======");
		dp.setIsHot(1);
		mapper.selectbyObj(dp);
		System.out.println("=======7======");
		dp.setPname("韩版");
		dp.setPdesc("双11");
		dp.setIsHot(1);
		mapper.selectbyObj(dp);
		
	}
	
	@Test
	public void test9() throws IOException {
			/**
			 * 组合查询
			 */
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
	    int [] cids= {1,2,3}	;
	    System.out.println(mapper.selectBycids(cids));
	}
	
	@Test
	public void test10() throws IOException {
			/**
			 * update动态SQL
			 * 
			 */
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		DmProduct dp=new DmProduct();
		dp.setPname("韩版");
		dp.setMarketPrice(555.0);
		dp.setId(1);
		mapper.update(dp);
		//从数据库中查找数据  验证
		DmProduct dpsp=mapper.selectbyId(1);
		
	   /**
	    * 1.在update之前将所有数据查询出来设置，再修改
	    * 缺点  
	    * 每次修改都是更新所有字段
	    * 2.用  set if 语句  
	    * 缺点  
	    * 无法将指定字段设置为null
	    */
	}
	@Test
	public void test11() throws IOException {
		
	DmOrderMapper dom=session.getMapper(DmOrderMapper.class);
	DmOrderitemMapper doim=session.getMapper(DmOrderitemMapper.class);
	DmOrderitem doi1=new DmOrderitem();
	DmOrderitem doi2=new DmOrderitem();
	DmOrders dom1=new DmOrders();
	//设置订单明细
	doi1.setCount(1);
	doi1.setTotal(100.0);
	doi1.setPid(1);
	
	doi2.setCount(1);
	doi2.setTotal(200.0);
	doi2.setPid(1);
	//设置订单
	dom1.setTotal(300.0);
	dom1.setState(1);
	dom1.setUid(1);
	dom1.setAid(1);
	try {
		dom.insert(dom1);
		/**
		 * 在添加订单明细时，要获取订单主键
		 * 二期项目是进行查询获取的id值
		 * 在多线程方式下会产生并发问题
		 * mybatis可以在insert的同时获取id值
		 */
		doi1.setOid(dom1.getId());
		doi2.setOid(dom1.getId());
		doim.insert(doi1);
		doim.insert(doi2);
		session.commit();
	}catch(Exception e) {
		e.printStackTrace();
		session.rollback();
	}finally{
		session.close();
	}
	
	}
	
	@Test
	public void test12() throws IOException {
			/**
			 * 缓存机制
			 * Cache Hit Ratio [com.yc.damai.Dao.DmProductMapper]: 0.0
			 * 缓存命中，当前查询结果在缓存中出现的概率
			 */
		DmProductMapper mapper=session.getMapper(DmProductMapper.class);
		DmProductMapper mapper2=session.getMapper(DmProductMapper.class);
	    int [] cids= {1000};
	    mapper.selectBycids(cids);
	    session.commit();
	    mapper2.selectBycids(cids);
	    mapper2.selectBycids(cids);
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
