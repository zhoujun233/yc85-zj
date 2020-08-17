package com.yc.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexAction {

	/**
	 * 打开首页
	 */
	@RequestMapping({ "/", "index" })
	public String index(@RequestParam(defaultValue = "") String order) {
		return "index" + order;
	}

	@RequestMapping("toTaobao")
	public String toTaobao() {
		return "taobao";
	}

	@RequestMapping("toBaidu")
	public String toBaidu() {
		return "baidu";
	}

	@RequestMapping("taobao/page")
	public String Taobao() {
		return "taobao";
	}

	@RequestMapping("baidu/page")
	public String baidu() {
		return "baidu";
	}

	@RequestMapping("Taobao")
	public String Taobao3() {
		return "taobao";
	}

	@RequestMapping("javaTaobao")
	public String Taobao4() {
		return "taobao";
	}

	@RequestMapping("jsTaobao")
	public String Taobao5() {
		return "taobao";
	}

	@RequestMapping("mysqlTaobao")
	public String Taobao6() {
		return "taobao";
	}

	@RequestMapping("xmlTaobao")
	public String Taobao7() {
		return "taobao";
	}

	@RequestMapping("page/taobao")
	public String Taobao8() {
		return "taobao";
	}

	@RequestMapping("page/?/taobao")
	public String Taobao11() {
		return "taobao";
	}

	@RequestMapping("page/a/?/taobao")
	public String Taobao9() {
		return "taobao";
	}

	@RequestMapping("page/a/b/c/taobao")
	public String Taobao10() {
		return "taobao";
	}

	@RequestMapping("toPage")
	public String Taobao12(@RequestParam(value = "flag", defaultValue = "") String flag,
			@RequestParam(value = "type", defaultValue = "") String type) {
		if(type.equals("2")||type.equals("3")||type.equals("4")) {
			return "baidu";
		}
		return "taobao";
	}
	
	
	@RequestMapping(name="form.do")
	public String baidu1() {
		return "baidu";
	}

	
	@RequestMapping(name="form.do",method = RequestMethod.POST)
	public String taobao() {
		return "taobao";
	}
	
	

	

}
