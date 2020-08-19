package com.zj.springmvc.web;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.damai.been.DmUser;
import com.yc.damai.util.Result;


@RestController
public class ValidAction {

	/**
	 * 1.在被校验的对象前加@Valid
	 * 2.在被校验的对象后紧跟Errors对象
	 * 
	 * error.hasErrors()  判断是否有错误
	 * error.hasFileErrors()  判断是否有字段错误
	 * 错误分成   1对象级错误   2字段级错误   3全局错误
	 * @param dm
	 * @param error
	 * @return
	 */
	@RequestMapping("regs.do")
	public Result reg(@Valid DmUser dm,Errors error) {
		if(error.hasErrors()) {
			return new Result(0, "注册失败", error.getAllErrors());
		}else {
			return new Result(1, "注册成功");
		}
		
		
		
	}

}
