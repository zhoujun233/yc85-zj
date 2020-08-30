package com.zj.crbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaServer
@SpringBootApplication
public class CrbookEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrbookEurekaApplication.class, args);
	}

	/**
	 * 定义 RestTemplate Bean
	 *//*
		 * @LoadBalanced
		 * 
		 * @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
		 */

}
