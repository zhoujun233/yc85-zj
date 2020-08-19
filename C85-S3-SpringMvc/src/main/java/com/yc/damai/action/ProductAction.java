package com.yc.damai.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.Dao.DmProductMapper;
import com.yc.damai.been.DmProduct;

@RestController("pAction")
public class ProductAction {
	
	@Resource
	private DmProductMapper pm;
	/**
	 * Model模型==>数据模型==》map集合可以替代Model
	 * 返回Model必须是页面跳转才行
	 * 如果是ajax 通过参数注入的map或model，会默认设置一个视图名导致错误
	 * ajax方式不能设置视图名
	 * 
	 * @param dp
	 * @param m
	 * @return
	 */
	@RequestMapping(path = "producthot",params = "op=query")
	public Map<String,Object> query(DmProduct dp){
		//dp.setIsHot(1);
		Map<String,Object> m=new HashMap<String,Object>();
		m.put("list",pm.selectforHot());
		return m;
		
	}
	
	

}
