package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zj.C85S3Blog.bean.Article;
import com.zj.C85S3Blog.dao.ArticleMapper;

@Controller
public class IndexAction {
	
	@Resource
	private ArticleMapper amapper;
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Article> list=amapper.selectByNew();
		
		model.addAttribute("alist", list);
		
		return "index";
	}

}
