package com.yc.spring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yc.spring.bmi.Container;
import com.yc.spring.bmi.Person;

@Configuration
public class BmiBeanConfig {

	@Bean()
	public Container getContainer() {
		Container container = new Container();
		Person p1 = new Person();
		Person p = new Person();
		container.setList(new ArrayList<>());
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		container.getList().add("123");
		p1.setName("宋江");
		container.setMax(p1);
		p.setName("燕青");
		container.setMin(p);
		return container;

	}

}
