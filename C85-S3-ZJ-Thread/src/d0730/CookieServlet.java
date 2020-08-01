package d0730;

public class CookieServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		  Cookie cookie=new Cookie("name","wusong");
		  cookie.setMaxAge(60*60*24);
		  response.addCookie(cookie);
		  cookie=new Cookie("sex","18");
		  response.addCookie(cookie);
		  response.getwWriter().append("cookie");
	}

}
