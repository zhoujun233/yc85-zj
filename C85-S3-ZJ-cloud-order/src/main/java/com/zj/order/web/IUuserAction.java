package com.zj.order.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name = "suser")//网元地址  服务器名字
public interface IUuserAction {
	
	@GetMapping("user")//action地址
	public String user();

}
