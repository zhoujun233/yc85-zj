package com.zj.crbook.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zj.crbook.bean.CrBook;
import com.zj.crbook.bean.CrBookWithBLOBs;
import com.zj.crbook.bean.CrShow;

@FeignClient("crbook")
public interface IBookAction {
	
	@GetMapping("book/getNewBooks")
    List<CrBook> getNewBooks();

	@GetMapping("book/getRecom1")
	List<CrShow> getRecom1();
	
	@GetMapping("book/getById")
	CrBookWithBLOBs getById(@RequestParam int id);
}
