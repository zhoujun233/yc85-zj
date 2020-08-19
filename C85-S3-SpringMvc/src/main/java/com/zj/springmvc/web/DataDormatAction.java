package com.zj.springmvc.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.been.DmOrders;


@RestController
public class DataDormatAction {
	
	@RequestMapping("addorders")
	public DmOrders save(DmOrders dm) {
		return dm;
		}

}
