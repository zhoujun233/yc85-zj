package d0730;


public class ToIndesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
       /**
        * 实现重定向
        */
		response.sendRedirect("/photo/index.html");
	}

}
