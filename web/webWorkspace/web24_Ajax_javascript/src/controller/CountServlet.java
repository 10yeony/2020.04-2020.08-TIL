package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//1. ajax01_count.html
		/*String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		out.print(id+" "+pass+"<br/> <b>Count :: "+ ++count+"</b>");*/
		
		//2. ajax02_Encoding.html
		String nick = request.getParameter("nick");
		
		try {
			//바로 즉각적으로 너무 빠른 속도로 응답되니까
			Thread.sleep(5000); //5초 동안 잡고 있음.
			//그럼 encoding.html에서 readyState가 2,3일  동안 5초 동안 그림 뜬다.
		}catch(Exception e) {
			
		}
		
		out.print(nick); //응답이 여기서 간다... 클라이언트로..
		//println()으로 하면 엔터키를 받아서 값을 못 받게 됨.
	}

}
