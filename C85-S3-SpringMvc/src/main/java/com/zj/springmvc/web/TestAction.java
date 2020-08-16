package com.zj.springmvc.web;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user") // 在类上的定义用于定义该类所有方法的共同路径
public class TestAction {

	@RequestMapping("?/add") // ?表示一个字符
	public String add() {
		return "add";

	}

	@RequestMapping("*/mod") // *表示1—n字符
	public String mod() {
		return "mod";

	}

	@RequestMapping("**/msg") // *表示1—n级目录
	public String msg() {
		return "msg";

	}

	/**
	 * 高级参数注入
	 */
	@RequestMapping("head")
	public String accept(@RequestHeader String accept,
			@RequestHeader(name = "Connection", required = true) String coon) {
		return accept + "<br>" + coon;
	}

	@RequestMapping("cookie")
	public String cookie(@CookieValue String user, @CookieValue int age,
			@RequestHeader(name = "Cookie") String cookie) {
		return user + "<br>" + age + "<br>" + cookie;
	}

	/**
	 * 应用上下文对象不能注入
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param in
	 * @param out
	 * @return
	 */
	@RequestMapping("servlet")
	public String servlet(HttpServletRequest request,
			HttpServletResponse response, 
			HttpSession session, 
			InputStream in,
			OutputStream out) {
		return request + "<br>" + response + "<br>" + session + "<br>" + in + "<br>" + out;
	}

}
