package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.zj.C85S3Blog.bean.Article;
import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.dao.ArticleMapper;
import com.zj.C85S3Blog.dao.CategoryMapper;

@Controller
public class IndexAction {

	@Resource
	private ArticleMapper amapper;
	@Resource
	private CategoryMapper cmapper;

	@GetMapping({"/","index.html"})
	public String index(Model model, @RequestParam(defaultValue = "1") int page) {
		// 执行查询前，必须先设置分页参数
		// 注意：必须是在查询方法前，调用设置分页参数
		PageHelper.startPage(page, 5);
		List<Article> list = amapper.selectByNew();
		List<Category>clist=cmapper.selectAll();
		List<Article> hlist = amapper.selectByHot();

		model.addAttribute("alist", list);
		model.addAttribute("clist", clist);
		model.addAttribute("hlist", hlist);

		return "index";
	}
	
	@GetMapping("category.do")
	public String category(Model m,int categoryid) {
		List<Article> list = amapper.selectByC(categoryid);
		m.addAttribute("alist", list);
		List<Category>clist=cmapper.selectAll();
		List<Article> hlist = amapper.selectByHot();
		m.addAttribute("clist", clist);
		m.addAttribute("hlist", hlist);
		return "index";
		
	}

}
