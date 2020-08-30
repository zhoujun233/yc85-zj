package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.bean.Daysput;
import com.zj.C85S3Blog.bean.Osad;
import com.zj.C85S3Blog.biz.OsadBiz;
import com.zj.C85S3Blog.dao.CategoryMapper;
import com.zj.C85S3Blog.util.Util;

@Controller
public class OsadAction {
	
	@Resource
	private CategoryMapper cmapper;
	@Resource
	private OsadBiz obiz;
	
	
	@GetMapping("osad")
	public String toOsad(Model m) {
		List<Category>clist=cmapper.selectAll();
		m.addAttribute("clist", clist);
		
		return "osad";
		
	}
	
	
	@PostMapping("osad.do")
	  public String insertOsad(@Valid() Osad o,Errors errors,Model m) {
		if(errors.hasErrors()) {
			m.addAttribute("errors", Util.asMap(errors));
			m.addAttribute("os", o);
			List<Category>clist=cmapper.selectAll();
			m.addAttribute("clist", clist);
			return "osad";
		}else {
			obiz.createo(o);
			List<Category>clist=cmapper.selectAll();
			m.addAttribute("clist", clist);
			return "redirect:osad";
		}
	  }
	 
	
	@PostMapping("daysput.do")
	public String insertDaysput(@Valid() Daysput dp,Errors errors,Model m) {
		if(errors.hasErrors()) {
			m.addAttribute("errors", Util.asMap(errors));
			m.addAttribute("sp", dp);
			List<Category>clist=cmapper.selectAll();
			m.addAttribute("clist", clist);
			return "osad";
		}else {
			obiz.created(dp);
			List<Category>clist=cmapper.selectAll();
			m.addAttribute("clist", clist);
			return "redirect:osad";
		}
		
		
		
	}
}
