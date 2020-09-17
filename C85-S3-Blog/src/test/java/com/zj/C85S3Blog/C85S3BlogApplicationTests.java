package com.zj.C85S3Blog;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.zj.C85S3Blog.util.CreatePhoneNumber;

@SpringBootTest
class C85S3BlogApplicationTests {
	
	@Resource
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		CreatePhoneNumber.sendPhoneNumber("17673471352");
	}

}
