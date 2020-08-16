package com.zj.springmvc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")//在类上的定义用于定义该类所有方法的共同路径
public class TestAction {

	@RequestMapping("?/add")//?表示一个字符
	public String add() {
		return "add";

	}

	@RequestMapping("*/mod")//*表示1—n字符
	public String mod() {
		return "mod";

	}

	@RequestMapping("**/msg")//*表示1—n级目录
	public String msg() {
		return "msg";

	}

}
