package d0730;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpServletResponse {
	private OutputStream out;
	private CharArrayWriter caw = new CharArrayWriter();
	private PrintWriter pw = new PrintWriter(caw);
	private int status;
	private String msg;
	// 存放头域键值对的map集合
	private Map<String, String> headerMap = new HashMap<>();
	private List<Cookie> cookielist = new ArrayList<>();
	public HttpServletResponse(OutputStream out) {
		this.out = out;
	}

	/**
	 * 获取响应输出流 临时保存servlet输出的内容
	 * 
	 * @return
	 */
	public PrintWriter getwWriter() {
		return pw;

	}

	/**
	 * 设置结果码 和说明
	 * 
	 * @param status
	 * @param msg
	 */
	public void setStatus(int status, String msg) {
		this.status = status;
		this.msg = msg;

	}

	/**
	 * 将响应报文传给服务器
	 * 
	 * @throws IOException
	 */
	public void flushBuffer() throws IOException {
		// 响应头行
		out.write(("HTTP/1.1 " + status + " " + msg + "\n").getBytes());
		// 响应头域
		out.write(("Content-Type: text/html; charset=utf-8\n").getBytes());
		// 将头域集合写入报文
		for (Entry<String, String> entry : headerMap.entrySet()) {
			out.write((entry.getKey() + ": " + entry.getValue() + "\n").getBytes());
		}
		//写入cookie
		for(Iterator<Cookie> iterator=cookielist.iterator();iterator.hasNext();) {
			Cookie cookie=iterator.next();
			out.write(cookie.toString().getBytes());
		}
		// 空行
		out.write("\n".getBytes());
		// 实体
		out.write(caw.toString().getBytes());

	}

	// 响应重定向方法
	public void sendRedirect(String uri) {
		// 写入结果码
		setStatus(301, "Redirect");
		// 头域中写入Location,uri要跳转的页面
		headerMap.put("Location", uri);
	}

	public void addCookie(Cookie cookie) {
		cookielist.add(cookie);
	}

}
