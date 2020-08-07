package com.yc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.dao.FavoriteMapper;
import com.yc.dao.TagMapper;
import com.yc.util.MyBatisHelper;

@WebServlet("/FavoriteServlet.do")//在web.xml也能配置url-pattern
public class FavoriteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void queryFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tid=request.getParameter("tid");
		SqlSession session = MyBatisHelper.openSession();
		FavoriteMapper fm = session.getMapper(FavoriteMapper.class);
		if(tid.equals("-1")) {
			Integer tid1=null;
			List<Favorite>list=fm.selectByTid(tid1);
			print(response, list);
		}else {
			List<Favorite>list=fm.selectByTid(Integer.valueOf(tid));
			print(response, list);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
