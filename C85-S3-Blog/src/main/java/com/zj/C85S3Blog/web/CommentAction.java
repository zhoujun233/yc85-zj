package com.zj.C85S3Blog.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.zj.C85S3Blog.bean.Comment;
import com.zj.C85S3Blog.bean.User;
import com.zj.C85S3Blog.biz.CommentBiz;
import com.zj.C85S3Blog.dao.CommentMapper;
import com.zj.C85S3Blog.util.Result;

@RestController
public class CommentAction {

	@Resource
	private CommentBiz cbiz;
	@Resource
	private CommentMapper cmapper;

	/**
	 * 文章评论
	 * 
	 * @param mav
	 * @param user
	 * @param content
	 * @param articleid
	 * @return
	 */
	@PostMapping("comment.do")
	public Result commit(@SessionAttribute("loginedUser") User user, Comment comment) {
		comment.setCreateby(user.getId());
		cbiz.insert(comment);

		return new Result(1, "评论成功", comment);

	}

	@GetMapping("query")
	public Result query(int articleid) {
		List<Comment> list = cmapper.select(articleid);
		return new Result(1, "评论成功", list);

	}

}
