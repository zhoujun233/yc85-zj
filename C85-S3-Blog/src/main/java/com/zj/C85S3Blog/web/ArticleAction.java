package com.zj.C85S3Blog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zj.C85S3Blog.bean.Article;
import com.zj.C85S3Blog.dao.ArticleMapper;

@Controller
public class ArticleAction {

	@Resource
	private ArticleMapper amapper;

	@GetMapping("article.do")
	public String article(Model m, int id) {

		Article art = amapper.selectById(id);
		m.addAttribute("art", art);

		return "article";

	}

}
