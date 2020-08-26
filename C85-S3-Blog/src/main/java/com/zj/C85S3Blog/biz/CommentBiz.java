package com.zj.C85S3Blog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zj.C85S3Blog.bean.Comment;
import com.zj.C85S3Blog.dao.CommentMapper;

@Service
public class CommentBiz {
	@Resource
	CommentMapper cmapper;
	
	public int insert(Comment comment) {
		return cmapper.insert(comment);
	}

}
