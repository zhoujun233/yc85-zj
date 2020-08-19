package com.zj.springmvc.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.damai.been.DmUser;


@RestController
@RequestMapping( path="user",produces = "text/html;charset=UTF-8") // 在类上的定义用于定义该类所有方法的共同路径
/* @SessionAttributes(names = "loginuser",types = Data.class)
 * name  用于监控数据模型中出现指定名字的对象
 * type  用于监控数据模型中出现指定类型的对象
 * SessionAttributes  与 @RestController有冲突，所以屏蔽
 * 
 *  */
public class TestAction {

	@RequestMapping(path="?/add") // ?表示一个字符
	public String add() {
		return "周军";

	}

	@RequestMapping("*/mod") // *表示1—n字符
	public String mod() {
		return "周军";

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
	public String servlet(HttpServletRequest request, HttpServletResponse response, HttpSession session, InputStream in,
			OutputStream out) {
		return request + "<br>" + response + "<br>" + session + "<br>" + in + "<br>" + out;
	}

	/**
	 * 地址参数
	 * url请求   login?user=root&pwd=123
	 * @return
	 *     /root/123/login
	 */

	@RequestMapping("{user}/{pwd}/login")
	public String login(@PathVariable("user") String user, @PathVariable() String pwd) {

		return user + "<br>" + pwd;

	}
	/**
	 * 会话对象的注入
	 * SprinMVC  数据模型  （map）   Model 请求过程中用于临时保存数据的对象
	 * @SessionAttributes   加在类上
	 * @SessionAttribute     加在方法参数前面
	 * 要在@RestController标注的类中给会话添加属性，要通过注入会话对象的方法
	 * @SessionAttribute   从会话中获取一个指定对象 ， 加在方法参数上
	 * @param user
	 * @param pwd
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("{user}/{pwd}/login.do")
	public String logindo(@PathVariable("user") String user, @PathVariable() String pwd,
			Model model,//该方法没有用上
			HttpSession session) {
        DmUser du=new DmUser();
        du.setCname(user);
        du.setPassword(pwd);
        session.setAttribute("loginuser", du);
        session.setAttribute("now", new Date());
        session.setAttribute("age", 18);
		return du.toString();

	}
	
	@RequestMapping("testlogin")
	public String testlogindo(@SessionAttribute("loginuser") DmUser du,
			@SessionAttribute("now")Date now,
			@SessionAttribute("age")Integer age) {
       
		return du+"<br>"+now+"<br>"+age;

	}

}
