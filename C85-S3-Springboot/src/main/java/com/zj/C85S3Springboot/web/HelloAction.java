package com.zj.C85S3Springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAction {
	
	@RequestMapping("hello")
	public String hello() {
		return "hello";
		
	}

}
