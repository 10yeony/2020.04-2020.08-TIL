package service.header;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrintHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get이든 post든 어떤 방식으로 요청으로 들어오든 로직은 여기에 작성.
		//양방향 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=cyan>");
		out.println("<h2>===================================</h2>");
		
		//header의 정보를 뽑아본다.
		/*Enumeration<String> en = request.getParameterNames();
		 * 폼에 있는 값들 뽑아내는 것*/
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()) {//key값이 있니 없니
			String key = en.nextElement();
			String value = request.getHeader(key);
			out.println(key+" : "+value+"<br/>");
		}
		out.println("<hr>");
		
		String id1 = request.getParameter("id");
		String id2 = request.getParameter("i");
		String pass2 = request.getParameter("p");
		out.println(id1+", "+id2+", "+pass2);
		out.println("</body></html>");
	}
}
