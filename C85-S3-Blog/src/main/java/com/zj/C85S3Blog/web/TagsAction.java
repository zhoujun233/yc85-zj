package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.bean.Flink;
import com.zj.C85S3Blog.dao.CategoryMapper;
import com.zj.C85S3Blog.dao.FlinkMapper;

@Controller
public class TagsAction {
	
	
	@Resource
	private CategoryMapper cmapper;
	@Resource
	private FlinkMapper fmapper;
	
	@GetMapping("toTags")
	public String toTags(Model m) {
		List<Category>clist=cmapper.selectAll();
		List<Flink>flist=fmapper.selectAll();
		m.addAttribute("clist", clist);
		m.addAttribute("flist", flist);
		return "tags";
		
	} 

}
