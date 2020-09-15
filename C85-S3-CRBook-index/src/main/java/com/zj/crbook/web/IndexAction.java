package com.zj.crbook.web;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zj.crbook.bean.CrBook;
import com.zj.crbook.bean.CrShow;
import com.zj.crbook.bean.CrUser;
import com.zj.crbook.bean.Result;
import com.zj.crbook.remote.IBookAction;
import com.zj.crbook.remote.IUserAction;

@Controller
public class IndexAction {

	@Resource
	private IBookAction iba;

	@Resource
	private IUserAction uaction;

	@RequestMapping("/")
	public String index(Model m) {

		List<CrShow> recom1 = iba.getRecom1();
		m.addAttribute("recom1", recom1);

		List<CrBook> nbooks = iba.getNewBooks();
		m.addAttribute("newbooks", nbooks);
		return "index";
	}

	@RequestMapping(path = { "tologin", "login.html" })
	public String tologin() {

		return "login";
	}

	@PostMapping("login")
	public String login(@Valid CrUser user, Errors error, Model m) {
		// 验证用户输入的数据是否正确
		
		if (error.hasErrors()) {
			m.addAttribute("errors", error.getFieldError());
			return "login";
		}
		// 发起远程服务调用， 传递2个参数（用户名，密码）
		Result res = uaction.login(user);
		
		if (res.getCode() == 1) {
			return index(m);
		} else {
			// 自定义一个错误
			error.rejectValue("account", "AccountOrPwdError", "用户名或密码错误");
			m.addAttribute("errors", error.getFieldError());
			// 如果错误，跳转回登录页
			return "login";
		}

	}

}
