package com.zj.crbook;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zj.crbook.bean.User;
import com.zj.crbook.bean.UserExample;
import com.zj.crbook.dao.UserMapper;

@SpringBootTest
public class ApplicationTests  {
	

	@Resource
	private UserMapper uMapper;
	
	@Test
	public void contextLoads() {
		
		// MyBatis 方向工程的接口的使用

				// 组合条件查询 <if>  ==> Example 对象构建条件

				UserExample ue = new UserExample();
				// == where account='zhangsan' and pwd='111'
				ue.createCriteria()
					.andAccountEqualTo("admin")
					.andPwdEqualTo("111");

				List<User> list = uMapper.selectByExample(ue);

				Assert.assertEquals(1, list.size());
	}

}
