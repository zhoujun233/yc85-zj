package com.zj.crbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class CrbookZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrbookZuulApplication.class, args);
	}

	/**
	 * 定义 RestTemplate Bean
	 *//*
		 * @LoadBalanced
		 * 
		 * @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
		 */

}
