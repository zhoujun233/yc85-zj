package com.zj.C85S3Blog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zj.C85S3Blog.bean.Comment;
import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.dao.CommentMapper;
import com.zj.C85S3Blog.dao.UserMapper;

@Service
@Transactional
public class CommentBiz {
	@Resource
	CommentMapper cmapper;
	@Resource
	UserMapper umapper;

	@Transactional()
	public Comment insert(Comment comment) {
		cmapper.insert(comment);
		User user = new User();
		user.setId(comment.getCreateby());
		umapper.updateById(user);
		User u1 = umapper.selectById(user);
		if (u1.getCommits() >= 20 && u1.getCommits() <= 40) {
			user.setType("铜牌读者");
			umapper.updateById1(user);
		} else if (u1.getCommits() > 40 && u1.getCommits() <= 60) {
			user.setType("银牌读者");
			umapper.updateById1(user);
		} else if(u1.getCommits() > 60){
			user.setType("金牌读者");
			umapper.updateById1(user);
		}
		return comment;

	}

}
