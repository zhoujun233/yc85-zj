package com.yc.damai.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yc.damai.Dao.DmCategroyMapper;
import com.yc.damai.been.DmCategory;

@WebServlet("/clist.do")
public class ClistServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession session;
   
	protected void clist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String pid=request.getParameter("pid");
	    
	    {
			String resource = "mybatis.xml";
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				session = sqlSessionFactory.openSession();
				DmCategroyMapper mapper=session.getMapper(DmCategroyMapper.class);
				List<DmCategory> dclist=mapper.selectAll();
				DmCategory dc=dclist.get(Integer.valueOf(pid));
				print(response, dc);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
