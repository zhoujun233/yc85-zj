package com.yc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yc.spring.bmi.Person;

@Configuration
public class BmiBeanConfig {
	
	@Bean()
	public Person getPerson() {
		Person p=new Person();
		
		return p;
		
	}

}
