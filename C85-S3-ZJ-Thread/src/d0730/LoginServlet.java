package d0730;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		  Cookie[] cookies=request.getCookies();
		  
		  response.getwWriter().append("用户名<input value='"+cookies[0].getValue()+"'><br>");
		  response.getwWriter().append("密码<input value=''><br>");
		  response.getwWriter().append("<input type='button' value='登录'><br>");
	}
}
