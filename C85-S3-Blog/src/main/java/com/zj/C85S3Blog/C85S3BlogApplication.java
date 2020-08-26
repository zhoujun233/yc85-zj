package com.zj.C85S3Blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zj.C85S3Blog.util.LoginInterceptor;

@SpringBootApplication
@MapperScan("com.zj.C85S3Blog.dao")
public class C85S3BlogApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(C85S3BlogApplication.class, args);
	}


	/**
	 * 	拦截器注册方法
	 * 	参数: 拦截器注册器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		
		InterceptorRegistration ir=registry.addInterceptor(new LoginInterceptor());
		ir.addPathPatterns("/addArticle.do","/addArticle","/comment.do");
		
	}
	
	

}
