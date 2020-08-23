package com.zj.C85S3Blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zj.C85S3Blog.dao")
public class C85S3BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(C85S3BlogApplication.class, args);
	}

}
