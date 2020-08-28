package com.zj.C85S3Blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.dao.ReaderMapper;

@Service
public class ReaderBiz {
	@Resource
	private ReaderMapper rmapper;
	
	public List<User> selectG(){
		User user=new User();
		user.setType("金牌读者");
		return rmapper.selectByType(user);
		
	}
	
	public List<User> selectY(){
		User user=new User();
		user.setType("银牌读者");
		return rmapper.selectByType(user);
		
	}
	
	public List<User> selectT(){
		User user=new User();
		user.setType("铜牌读者");
		return rmapper.selectByType(user);
		
	}
	
	public List<User> selectC(){
		User user=new User();
		user.setType("普通读者");
		return rmapper.selectByType(user);
		
	}

}
