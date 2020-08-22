package com.zj.C85S3Springboot.biz;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.zj.C85S3Springboot.bean.DmUser;

@SpringBootTest
public class UserbizTest {
	
	@Resource
	private UserBiz ubiz;
	
	 @MockBean
	 private Userdao udao;
	 
	
	@Test
	public void logintest() {
		try {
			//模拟结果对象
			DmUser dbuser=new DmUser();
			//模拟方法调用结果
			Mockito.when(udao.selectByUser("武松", "123")).thenReturn(dbuser);
			
			DmUser user=ubiz.Login("武松", "123");
			Assert.isTrue(user!=null, "没找到指定用户");
			
		} catch (BizException e) {
			Assert.isTrue(e==null, "dao类异常");
			e.printStackTrace();
		}
		
	}
	
	

}
