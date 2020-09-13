package com.zj.crbook.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.zj.crbook.bean.CrBook;

@FeignClient("crbook")
public interface IBookAction {
	
	@GetMapping("book/getNewBooks")
    List<CrBook> getNewBooks();
}
