package com.yc.cinema.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.yc.cinema.biz.CommentsBiz;
import com.yc.cinema.biz.UserBiz;

@Controller
public class UserAction {
	@Autowired  //根据类型自动装配   speing提供
	private UserBiz ubiz;
	@Resource    //先根据id自动装配,如果没有找到再根据类型自动装配   java提供
	private CommentsBiz cbiz;

	public UserBiz getUbiz() {
		return ubiz;
	}

	public void setUbiz(UserBiz ubiz) {
		this.ubiz = ubiz;
	}

	public CommentsBiz getCbiz() {
		return cbiz;
	}

	public void setCbiz(CommentsBiz cbiz) {
		this.cbiz = cbiz;
	}

}
