package com.zj.C85S3Springboot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.zj.C85S3Springboot.biz.SendMail;
import com.zj.C85S3Springboot.dao.DmProductMapper;

@SpringBootTest
class C85S3SpringbootApplicationTests {
	
	@Resource
	DmProductMapper mapper;
	
	@Resource
	SendMail sm;

	@Test
	void contextLoads() {
		Assert.isTrue(mapper.selectAll().size()>0, "没有数据");
	}
	
	@Test
	void testMail() {
		sm.sendSimpleMail("1529072552@qq.com", "登录验证码", "你好，你的登录验证码为12005");
	}


}
