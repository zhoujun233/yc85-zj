package com.zj.C85S3Blog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.C85S3Blog.bean.Flink;
import com.zj.C85S3Blog.dao.FlinkMapper;

@Service
public class FlinkBiz {
	
	@Resource
	private FlinkMapper fmapper;
	
	public int insert(Flink f) {
		return fmapper.insert(f);
	}

	
}
