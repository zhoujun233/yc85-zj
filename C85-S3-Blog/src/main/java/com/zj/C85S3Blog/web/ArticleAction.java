package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zj.C85S3Blog.bean.Article;
import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.bean.Comment;
import com.zj.C85S3Blog.bean.Osad;
import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.biz.ArticleBiz;
import com.zj.C85S3Blog.biz.CommentBiz;
import com.zj.C85S3Blog.dao.ArticleMapper;
import com.zj.C85S3Blog.dao.CategoryMapper;
import com.zj.C85S3Blog.dao.OsdaMapper;
import com.zj.C85S3Blog.dao.UserMapper;
import com.zj.C85S3Blog.util.Result;
import com.zj.C85S3Blog.util.Util;

@RestController
public class ArticleAction {

	@Resource
	private ArticleMapper amapper;
	@Resource
	private CategoryMapper cmapper;
	@Resource
	private ArticleBiz abiz;
	@Resource
	private CommentBiz cbiz;
	
	@Resource
	private OsdaMapper omapper;
	@Resource
	private UserMapper umapeer;
	

	/*
	 * @GetMapping("article.do") public String article(Model m, int id) {
	 * List<Category> clist = cmapper.selectAll(); List<Article> hlist =
	 * amapper.selectByHot(); Article art = amapper.selectById(id);
	 * m.addAttribute("art", art); m.addAttribute("hlist", hlist);
	 * m.addAttribute("clist", clist); return "article";
	 * 
	 * }
	 */
/**
 * ModelAndView使用这个可以返回
 *          Model  数据    thymeleaf
 *          View   视图    HTML
 * @param mav
 * @param id
 * @return
 */
	@GetMapping("article.do")
	public ModelAndView Article(ModelAndView mav, int id,@SessionAttribute("loginedUser") User user) {
		List<Category> clist = cmapper.selectAll();
		List<Article> hlist = amapper.selectByHot();
		Article art = amapper.selectById(id);
		Osad os=omapper.selectById();
		amapper.updateById(id);
		User user1=umapeer.selectById(user);
		
		mav.addObject("art", art);
		mav.addObject("hlist", hlist);
		mav.addObject("clist", clist);
		mav.setViewName("article");
		mav.addObject("os", os);
		mav.addObject("user1", user1);
		
		return mav;

	}

	
	@GetMapping("addArticle")
	public ModelAndView toArticle(ModelAndView mav) {
		List<Category> clist = cmapper.selectAll();
		List<Article> hlist = amapper.selectByHot();
		Osad os=omapper.selectById();
		mav.addObject("hlist", hlist);
		mav.addObject("clist", clist);
		mav.addObject("os", os);
		mav.setViewName("addArticle");
		
		return mav;

	}
	
	//发表文章
	@PostMapping("addArticle.do")
	public ModelAndView addArticle(@Valid Article a,Errors errors,ModelAndView mav,
			@SessionAttribute("loginedUser")User user) {
		if(errors.hasErrors()) {
			List<Category> clist = cmapper.selectAll();
			List<Article> hlist = amapper.selectByHot();
			Osad os=omapper.selectById();
			mav.addObject("hlist", hlist);
			mav.addObject("clist", clist);
			mav.addObject("os", os);
			mav.addObject("errors", Util.asMap(errors));
			mav.addObject("Article", a);
			mav.setViewName("addArticle");
		}else {
			a.setAuthor(user.getName());
			abiz.creat(a);
			//mav.setViewName("article");//展示新文章
			/**
			 * 重定向   服务器 action==>article 浏览器    article?id ==》服务器action
			 */
			mav.setViewName("redirect:article.do?id=" + a.getId());
		}
		
		return mav;

	}
	
	
	
	
	
	
	
	

}
