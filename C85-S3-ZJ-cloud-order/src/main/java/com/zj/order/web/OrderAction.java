package com.zj.order.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderAction {

	@Resource
	private RestTemplate res;

	@GetMapping("order")
	public String order(HttpServletRequest req) {
		return String.format("server:order ; ip:%s ; port:%s", req.getLocalAddr(), req.getLocalPort());

	}

	/**
	 * 	127.0.0.1:8002 ==> 订单地址
	 * 	浏览器测试地址: http://127.0.0.1:8002/user
	 * 				http://order/user  
	 */
	@GetMapping("user")
	public String user() {
		//String url = "http://127.0.0.1:8001/user";
		String url = "http://suser/user";//// 系统内部的远程调用地址
		String str = res.getForObject(url, String.class);
		return str;

	}

}
