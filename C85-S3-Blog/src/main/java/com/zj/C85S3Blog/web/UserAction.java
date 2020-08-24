package com.zj.C85S3Blog.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.biz.BizException;
import com.zj.C85S3Blog.biz.UserBiz;
import com.zj.C85S3Blog.util.Result;

@Controller
public class UserAction {

	@Resource
	private UserBiz ubiz;

	@PostMapping("reg.do")
	public String Reg(@Validated User user,Errors errors, Model m) {
		if(errors.hasErrors()) {
			return "reg";
		}
		try {
			ubiz.reg(user);
		} catch (BizException e) {
			errors.rejectValue("account", "account", e.getMessage());
			m.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "reg";
		}
		return "index";
	}
	@GetMapping("reg")
	public String toreg() {
		
		return "reg";
	}
	@PostMapping("index.do")
	public Result Login(User user, HttpSession session) {
		try {
			User duser = ubiz.Login(user);
			session.setAttribute("LoginedUser", duser);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(e.getMessage());
		}
		return new Result(1, "登录成功");
	}

}
