package com.zj.C85S3Blog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.C85S3Blog.bean.Article;
import com.zj.C85S3Blog.dao.ArticleMapper;

@Service
public class ArticleBiz {
	
	@Resource
	private ArticleMapper amapper;
	
	public int creat(Article a) {
		
		return amapper.insert(a);
		
	}

}
