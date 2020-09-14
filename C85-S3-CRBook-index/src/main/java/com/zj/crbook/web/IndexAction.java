package com.zj.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zj.crbook.bean.CrBook;
import com.zj.crbook.bean.CrShow;
import com.zj.crbook.remote.IBookAction;

@Controller
public class IndexAction {
	
	@Resource
	private IBookAction iba;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		List<CrShow> recom1 = iba.getRecom1();
		m.addAttribute("recom1", recom1);

		List<CrBook> nbooks=iba.getNewBooks();
		m.addAttribute("newbooks", nbooks);
		return "index";
	}
	@RequestMapping(path = {"login","login.html"})
	public String tologin() {
		
		
		return "login";
	}
	

}
