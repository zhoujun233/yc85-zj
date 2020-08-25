package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zj.C85S3Blog.bean.Article;
import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.dao.ArticleMapper;
import com.zj.C85S3Blog.dao.CategoryMapper;

@Controller
public class ArticleAction {

	@Resource
	private ArticleMapper amapper;
	@Resource
	private CategoryMapper cmapper;

	@GetMapping("article.do")
	public String article(Model m, int id) {
		List<Category>clist=cmapper.selectAll();
		List<Article> hlist = amapper.selectByHot();
		Article art = amapper.selectById(id);
		m.addAttribute("art", art);
		m.addAttribute("hlist", hlist);
		m.addAttribute("clist", clist);
		return "article";

	}

}
