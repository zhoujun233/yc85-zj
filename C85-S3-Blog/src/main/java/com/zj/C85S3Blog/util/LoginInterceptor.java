package com.zj.C85S3Blog.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 
	 * 	是在请求到控制器之前执行, 返回false之终止方法
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getSession().getAttribute("loginedUser")==null) {
			String accept=request.getHeader("Accept");
			if(accept.startsWith("application/json")) {
				//ajax
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().append("{\"code\":\"0\",\"msg\":\"请先登录系统\"}");
			}else {
				//页面跳转
				response.setContentType("text/html;charset=utf-8");
				response.sendRedirect("/?mustLogin");
			}
			return false;
		}
		return true;
	}
	
	

}
