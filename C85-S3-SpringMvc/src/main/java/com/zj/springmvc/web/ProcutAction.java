package com.zj.springmvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zj.springmvc.damai.bean.DmCart;
import com.zj.springmvc.damai.bean.DmProduct;
//@Controller返回的是页面
import com.zj.springmvc.damai.bean.DmUser;
@RestController   //返回的是JSON
public class ProcutAction {
	/**
	 * path==>value 互为同义词
	 *  headers 定义请求头域中的字段值 例如：Cookie 
	 *  method 定义响应的类型 例如GET,POST...
	 * params 定义参数的限定 例如a=100(参数中必须有a=100) a(参数中必须有a) 
	 * consumes 消费：定义请求内容的类型
	 *  produces 产品：定义响应内容的类型
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value = "product.do", params = "op=query")
	public String query() {
		return "query!!";
	}

	// @GetMapping===@RequestMapping(method = RequestMethod.Get )
	@GetMapping(value = "product.do", params = "op=mod")
	public String mod() {
		return "mod!!";
	}

	@RequestMapping(value = "product.do", params = "op=add", method = RequestMethod.POST)
	public String add() {
		return "add!!";
	}

	@RequestMapping(value = "product.do", params = "op=aks",
			headers = {"Host=localhost:8888","Cookie"})
	public String msg() {
		return "msg!!";
	}
	/**
	 * 获取请求参数
	 * SpringMVC 对于简单的请求参数，数字，字符串，布尔
	 * 可以直接将请求参数注入到方法参数中
	 * 必须满足：
	 * 1.方法参数名==请求参数名
	 * 2.类型要兼容
	 */
	@GetMapping("login")
	public String login(String user,String pwd) {
		return user+":"+pwd;
		
	}
	/**
	 * 如果对象接受请求参数
	 * 对象的属性名与请求参数映射
	 * 请求参数==>对象  装箱==>java  包装类    装箱
	 * 对于一些特殊的数据类型 （日期）  需要使用springmvc转换器进行值的转换
	 * @param dm
	 * @param dp
	 * @return
	 */
	@GetMapping("reg.do")
	public String login(DmCart dm,DmProduct dp) {
		return dm.toString()+":"+dp.toString();
	}
	/**
	 * 自定义映射
	 * @param uid
	 * @param money
	 * @return
	 */
	@GetMapping("pay.do")
	public String pay(@RequestParam(
			name = "userid",//请求参数名
			defaultValue = "1",//默认值
			required = true   //必须写
			)String uid,Double money) {
		return uid+":"+money;
	}
	@GetMapping("findUser.do")
	public DmUser finduser() {
		DmUser du=new DmUser();
		du.setCname("lisi");
		du.setId(1);
		du.setPassword("123");
		return du;
	}

}
