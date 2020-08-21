package com.zj.C85S3Springboot.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zj.C85S3Springboot.bean.DmProduct;
import com.zj.C85S3Springboot.dao.DmProductMapper;

@Controller
//templates目录下
public class IndexAction {
	
	@Resource
	DmProductMapper pm;
	
	@GetMapping("index.do")
	public String index(Model model) {
		List<DmProduct>hlist=pm.selectforHot();
		
		model.addAttribute("hlist", hlist);
		//传入集合给页面
		List<DmProduct>nlist=pm.selectforNew();
		
		model.addAttribute("nlist", nlist);
		
		return "index";
		
	}
	
	
	
	@GetMapping("detail.do")
	public String detail(Model m, int id) {
		// 查询指定id商品
		DmProduct dp = pm.selectById(id);
		// 推送给页面
		m.addAttribute("dp", dp);
		return "detail";
	}

}
