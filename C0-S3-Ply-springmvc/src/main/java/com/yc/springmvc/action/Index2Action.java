package com.yc.springmvc.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.springmvc.bean.Result;

@RestController
public class Index2Action {
	
	@RequestMapping(name="call.do",method = RequestMethod.POST)
	public String change(@RequestParam("type")String type) {
		if(type.equals("2")) {
			return "taobao";
		}
		return "";
	}
	
	@RequestMapping(name="call1.do",method = RequestMethod.POST)
	public Result change2(@RequestParam("type")String type) {
		com.yc.springmvc.bean.Result r=new com.yc.springmvc.bean.Result();
		if(type.equals("2")) {
			r.setMsg("跳转淘宝");
			r.setUrl("toTaobao");
			return r;
		}
		r.setMsg("跳转百度");
		r.setUrl("toBaidu");
		return r;
	}
	
	
	@RequestMapping(name="exec.do",method = RequestMethod.POST)
	public Result change3() {
		com.yc.springmvc.bean.Result r=new com.yc.springmvc.bean.Result();
			r.setMsg("跳转百度");
			r.setUrl("toBaidu");
			return r;
	}
	
	
	
	
	
	
	
	
	
	

}
