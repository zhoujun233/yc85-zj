package com.zj.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.zj.crbook.bean.CrBook;
import com.zj.crbook.bean.CrBookExample;
import com.zj.crbook.bean.CrBookWithBLOBs;
import com.zj.crbook.bean.CrShow;
import com.zj.crbook.bean.CrShowExample;
import com.zj.crbook.dao.CrBookMapper;
import com.zj.crbook.dao.CrShowMapper;
@RestController
@RequestMapping("book")
public class BookAction {
	
	@Resource
	private CrBookMapper cbmapper;
	@Resource
	private CrShowMapper csm;

	
	@GetMapping("getNewBooks")
	public List<CrBook> getNewBooks(){
		CrBookExample cbe=new CrBookExample();
		cbe.setOrderByClause("id desc");
		//分页查询前12本书
		PageHelper.startPage(1, 12);
		return cbmapper.selectByExample(cbe);
		
	}
	
	// 查首页的第一个编辑推荐
		@GetMapping("getRecom1")
		public List<CrShow> getRecom1(){
			// 构建图书的查询条件以及排序
			CrShowExample cse = new CrShowExample();
			cse.createCriteria().andPageEqualTo("index").andBoardEqualTo("编辑推荐");
			// 分页查询出前12本书
			PageHelper.startPage(1, 12);
			return csm.selectByExample(cse);
		}
		
		
		@GetMapping("getById")
		public CrBookWithBLOBs getById(@RequestParam int id){
			
			return cbmapper.selectByPrimaryKey(id);
			
		}


}
