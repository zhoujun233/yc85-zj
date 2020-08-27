package com.zj.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserAction {

	@Resource
	private RestTemplate res;

	@GetMapping("user")
	public String user(HttpServletRequest req) {
		return String.format("server:user ; ip:%s ; port:%s", req.getLocalAddr(), req.getLocalPort());

	}
	
	/**
	 * 	127.0.0.1:8002 ==> 用户地址
	 * 	浏览器测试地址: http://127.0.0.1:8001/order
	 * 	
	 */
	
	@GetMapping("order")
	public String order() {
		//String url = "http://127.0.0.1:8002/order";
		String url = "http://sorder/order";
		String str = res.getForObject(url, String.class);
		return str;

	}

}
