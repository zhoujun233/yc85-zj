package com.zj.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.zj.crbook.bean.CrBook;
import com.zj.crbook.bean.CrBookExample;
import com.zj.crbook.dao.CrBookMapper;
@RestController
@RequestMapping("book")
public class BookAction {
	
	@Resource
	private CrBookMapper cbmapper;
	
	@GetMapping("getNewBooks")
	public List<CrBook> getNewBooks(){
		CrBookExample cbe=new CrBookExample();
		cbe.setOrderByClause("id desc");
		//分页查询前12本书
		PageHelper.startPage(1, 12);
		return cbmapper.selectByExample(cbe);
		
	}

}
