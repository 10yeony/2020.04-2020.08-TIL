package servlet.result;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSucess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		out.println("<html><head><script>alert('로그인 성공')</script></head><body>");
		out.println("<p align=center>"+id+"님이 로그인 되었습니다.!!!</p><br/><br/>");
		out.println("<p align=center><a href=#>도서 등록</a></p>");
		out.println("<p align=center><a href=intro.html>로그아웃</a></p>");
	}
}
