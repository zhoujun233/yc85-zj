package com.yc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Tag;
import com.yc.dao.TagMapper;
import com.yc.util.MyBatisHelper;

@WebServlet("/TagServlet.do")
public class TagServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void queryTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession session = MyBatisHelper.openSession();
		TagMapper tm = session.getMapper(TagMapper.class);
		List<Tag>list=tm.selectAll();
		print(response, list);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
