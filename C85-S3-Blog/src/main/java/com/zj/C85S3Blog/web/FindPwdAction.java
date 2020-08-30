package com.zj.C85S3Blog.web;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.zj.C85S3Blog.bean.Article;
import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.bean.Osad;
import com.zj.C85S3Blog.dao.ArticleMapper;
import com.zj.C85S3Blog.dao.CategoryMapper;
import com.zj.C85S3Blog.dao.OsdaMapper;
import com.zj.C85S3Blog.dao.UserMapper;
import com.zj.C85S3Blog.util.Result;
import com.zj.C85S3Blog.util.SendMail;

@RestController
public class FindPwdAction {

	@Resource
	private ArticleMapper amapper;
	@Resource
	private CategoryMapper cmapper;
	@Resource
	private SendMail sm;
	@Resource
	private RedisTemplate<String, String> rt;
	@Resource
	private UserMapper umapper;
	@Resource
	private OsdaMapper omapper;

	@GetMapping("findpwd")
	public ModelAndView toreg(ModelAndView m) {
		List<Category> clist = cmapper.selectAll();
		List<Article> hlist = amapper.selectByHot();
		Osad os=omapper.selectById();
		m.addObject("hlist", hlist);
		m.addObject("clist", clist);
		m.addObject("os", os);
		m.setViewName("findpwd");
		return m;
	}

	@RequestMapping("sendmail")
	public Result sendEmail(@RequestParam(value = "email") String email, HttpSession session) {
		session.setAttribute("email", email);
		Random r = new Random();
		int num = 1000 + r.nextInt(8999);
		sm.sendSimpleMail(email, "找回密码验证码", "你好，你的验证码为" + num + "，有效期为10分钟，请尽快处理");
		
		rt.opsForValue().set("vcode", String.valueOf(num),10,TimeUnit.MINUTES);
		
		return new Result(1, "验证码已发送");

	}
	
	@RequestMapping("checkvcode")
	public Result check(@RequestParam(value = "account") String account,
			@RequestParam(value = "pwd") String pwd,@RequestParam(value = "vcode") String vcode) {
		String s = rt.opsForValue().get("vcode");
		
		if(s.equals(vcode)) {
			umapper.updatepwd(pwd, account);
			return new Result(1,"密码修改成功");
		}else {
			return new Result(0,"验证码不正确");
		}
	} 

}
