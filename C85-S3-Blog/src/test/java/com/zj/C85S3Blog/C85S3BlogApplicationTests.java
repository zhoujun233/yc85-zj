package com.zj.C85S3Blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zj.C85S3Blog.util.CreatePhoneNumber;

@SpringBootTest
class C85S3BlogApplicationTests {

	@Test
	void contextLoads() {
		CreatePhoneNumber.sendPhoneNumber("17673471352");
	}

}
