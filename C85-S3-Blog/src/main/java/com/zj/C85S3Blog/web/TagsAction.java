package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.bean.Flink;
import com.zj.C85S3Blog.biz.FlinkBiz;
import com.zj.C85S3Blog.dao.CategoryMapper;
import com.zj.C85S3Blog.dao.FlinkMapper;
import com.zj.C85S3Blog.util.Util;

@RestController
public class TagsAction {
	
	
	@Resource
	private CategoryMapper cmapper;
	@Resource
	private FlinkMapper fmapper;
	@Resource
	private FlinkBiz fbiz;
	
	@GetMapping("toTags")
	public ModelAndView toTags(ModelAndView mav) {
		List<Category>clist=cmapper.selectAll();
		List<Flink>flist=fmapper.selectAll();
		mav.addObject("clist", clist);
		mav.addObject("flist", flist);
		mav.setViewName("tags");
		return mav;
		
	} 
	
	@PostMapping("addFlink.do")
	public ModelAndView insert(@Valid Flink f,Errors errors,ModelAndView mav) {
		if(errors.hasErrors()) {
			mav.addObject("errors", Util.asMap(errors));
			mav.addObject("Flink", f);
			mav.setViewName("tags");
		}else {
			fbiz.insert(f);
			mav.setViewName("redirect:toTags");
		}
		List<Category>clist=cmapper.selectAll();
		List<Flink>flist=fmapper.selectAll();
		mav.addObject("clist", clist);
		mav.addObject("flist", flist);
		return mav;
	}

}
