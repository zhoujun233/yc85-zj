package com.yc.springmvc.action;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.springmvc.bean.Result;

@RestController
public class Index2Action {

	@RequestMapping(value = "call.do", method = RequestMethod.POST)
	public String jump1(@RequestParam(value = "type") String type) {
		if (type.equals("2")) {
			return "taobao";
		}
		return "baidu";
	}

	@RequestMapping(value = "call1.do", method = RequestMethod.POST)
	public Result change2(@RequestParam("type") String type) {
		Result r = new Result();
		if (type.equals("2")) {
			r.setMsg("跳转淘宝");
			r.setUrl("toTaobao");
			return r;
		}
		r.setMsg("跳转百度");
		r.setUrl("toBaidu");
		return r;
	}

	@PostMapping(value = "exec.do")
	public Result change3() {
		Result r = new Result();
		r.setMsg("跳转百度");
		r.setUrl("toBaidu");
		return r;
	}
	@RequestMapping(value = "exec.do")
	public Result change4() {
		Result r = new Result();
		r.setMsg("跳转淘宝");
		r.setUrl("toTaobao");
		return r;
	}

}
