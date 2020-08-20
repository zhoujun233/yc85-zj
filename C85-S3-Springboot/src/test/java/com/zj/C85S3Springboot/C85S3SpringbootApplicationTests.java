package com.zj.C85S3Springboot;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.zj.C85S3Springboot.dao.DmProductMapper;

@SpringBootTest
class C85S3SpringbootApplicationTests {
	
	@Resource
	DmProductMapper mapper;

	@Test
	void contextLoads() {
		Assert.isTrue(mapper.selectAll().size()>0, "没有数据");
	}

}
