package com.zj.C85S3Springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@MapperScan("com.zj.C85S3Springboot.dao")
//开启定时任务
@EnableScheduling
public class C85S3SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(C85S3SpringbootApplication.class, args);
	}

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
		
	}
}
