package com.zj.C85S3Springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zj.C85S3Springboot.dao")
public class C85S3SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(C85S3SpringbootApplication.class, args);
	}

}
