package com.yc.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yc.bean.Favorite;
import com.yc.util.FavoriteBiz;

@WebServlet("/addServlet.do")
public class AddServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Favorite f=new Favorite();
		try {
			BeanUtils.populate(f, request.getParameterMap());
			FavoriteBiz fb=new FavoriteBiz();
			fb.addFavorite(f);
			response.getWriter().append("添加成功");
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			response.getWriter().append("添加失败");
		}
	}

	
	

}
