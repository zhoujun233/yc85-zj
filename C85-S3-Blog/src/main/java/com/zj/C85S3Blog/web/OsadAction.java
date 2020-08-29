package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.dao.CategoryMapper;

@Controller
public class OsadAction {
	
	@Resource
	private CategoryMapper cmapper;
	
	
	@GetMapping("osad")
	public String toOsad(Model m) {
		List<Category>clist=cmapper.selectAll();
		m.addAttribute("clist", clist);
		
		return "osad";
		
	}

}
