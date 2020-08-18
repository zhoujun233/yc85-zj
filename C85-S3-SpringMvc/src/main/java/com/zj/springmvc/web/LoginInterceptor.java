package com.zj.springmvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 判断当前是否登录
		if (request.getSession().getAttribute("LoginUser") == null) {
			// 根据当前的请求返回不同的结果
			// 判断当前是HTML还是ajax请求
			String accept = request.getHeader("Accept");
			if (accept.startsWith("application/json")) {
				// ajax请求
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().append("{code:0,msg:'请先登录系统'}");
			} else {
				response.setContentType("application/json;charset=utf-8");
				response.sendRedirect("/index.html");
			}
			return false;
		}
		// 正常业务返回true
		return true;
	}

}
