package com.zj.C85S3Blog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.C85S3Blog.bean.Daysput;
import com.zj.C85S3Blog.bean.Osad;
import com.zj.C85S3Blog.dao.OsdaMapper;

@Service
public class OsadBiz {
	@Resource
	private OsdaMapper omapper;
	
	public Osad createo(Osad o) {
		
		omapper.inserto(o);
		
		return o;
		
	}
    public Daysput created(Daysput dp) {
		
		omapper.insertd(dp);
		
		return dp;
		
	}
}
