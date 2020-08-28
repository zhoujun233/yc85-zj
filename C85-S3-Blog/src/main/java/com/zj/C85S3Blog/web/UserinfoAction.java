package com.zj.C85S3Blog.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.zj.C85S3Blog.bean.Category;
import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.dao.ArticleMapper;
import com.zj.C85S3Blog.dao.CategoryMapper;
import com.zj.C85S3Blog.dao.UserMapper;

@Controller
public class UserinfoAction {
	
	@Resource
	private CategoryMapper cmapper;
	@Resource
	private UserMapper umapper;
	@Resource
	private ArticleMapper amapper;
	
	@GetMapping("userinfo")
	public String userinfo(Model m,@SessionAttribute("loginedUser") User user) {
	
		m.addAttribute("alist", amapper.selectByA(user.getName()));
		m.addAttribute("user", umapper.selectById1(user.getId()));
		List<Category>clist=cmapper.selectAll();
		m.addAttribute("clist", clist);
		
		return "userinfo";
		
	}
	
	@PostMapping("upload1.do")
	//@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,@SessionAttribute("loginedUser") User user) throws IllegalStateException, IOException {
		String dispath = "E:/images/";
		String spath="/images/";
		String filename = file.getOriginalFilename();// 文件名
		file.transferTo(new File(dispath + filename));//,@SessionAttribute("loginedUser") User user
		umapper.updatehead(spath + filename,user.getId());
		//m.addAttribute("img", dispath + filename);
		
		return "redirect:userinfo";
	}

}
