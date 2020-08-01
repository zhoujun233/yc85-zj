package d0730;

public class PostServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
	     String name=request.getParameter("name");
	     String pwd=request.getParameter("pwd");
	     String phone=request.getParameter("phone");
	     String file=request.getParameter("file");
		
		  response.getwWriter().append("名字是："+name+"<br>");
		  response.getwWriter().append("密码是："+name+"<br>");
		 
	     
	}

}
