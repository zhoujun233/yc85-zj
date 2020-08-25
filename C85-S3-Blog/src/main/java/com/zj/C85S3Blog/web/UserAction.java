package com.zj.C85S3Blog.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zj.C85S3Blog.bean.Article;
import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.biz.BizException;
import com.zj.C85S3Blog.biz.UserBiz;
import com.zj.C85S3Blog.dao.ArticleMapper;
import com.zj.C85S3Blog.dao.CategoryMapper;
import com.zj.C85S3Blog.util.Result;
import com.zj.C85S3Blog.util.Util;

@Controller
public class UserAction {

	@Resource
	private UserBiz ubiz;
	@Resource
	private ArticleMapper amapper;
	@Resource
	private CategoryMapper cmapper;

	/**
	 * 注册 : 表单提交 ==> 页面跳转 Errors 报错所有的验证错误信息, 默认会被推送页面
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@PostMapping("reg.do")
	public String register(@Valid User user, Errors errors, Model m) {
		if (errors.hasErrors()) {
			m.addAttribute("errors", Util.asMap(errors));
			m.addAttribute("user", user);

			return "reg";
		}
		try {
			ubiz.register(user);
		} catch (BizException e) {
			e.printStackTrace();
			errors.rejectValue("account", "account", e.getMessage());
			m.addAttribute("errors", Util.asMap(errors));
			m.addAttribute("user", user);

			return "reg";
		}
		// index 请求转发方式跳转到 index
		// 使用响应重定向方式跳转
		return "redirect:/";
		// return "index";
	}

	@GetMapping("toreg")
	public String toreg(Model m) {
		List<Category> clist = cmapper.selectAll();
		List<Article> hlist = amapper.selectByHot();
		m.addAttribute("hlist", hlist);
		m.addAttribute("clist", clist);
		return "reg";
	}

	@PostMapping("upload.do")
	//@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,Model m) throws IllegalStateException, IOException {
		String dispath = "E:/images/";
		String filename = file.getOriginalFilename();// 文件名
		file.transferTo(new File(dispath + filename));
		return dispath + filename;
	}

	/**
	 * 登录: Ajax提交 ==> Vue
	 */

	@PostMapping("login.do")
	@ResponseBody
	public Result login(@Valid User user, Errors errors, HttpSession session) {
		try {
			if (errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")) {
				//将错误结果转成集合再返回
				Result res = new Result(0, "验证错误!", Util.asMap(errors));
				return res;
			}
			User dbuser = ubiz.Login(user);
			session.setAttribute("loginedUser", dbuser);
			return new Result(1, "登录成功!", dbuser);
			
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(e.getMessage());
		}
	}

	

}
