package com.encore;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equals("wordCount")) {
			wordCount(request, response);
		} else if (action.equals("kickCount")) {
			kickCount(request, response);
		}
	}// process()

	private void wordCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		    Count count = new Count();
		    String book = request.getParameter("book");
		    String result = count.execute(book);
		    
		    //JSP로 결과를 보내고 ajax는 JSP에서 가져옴
		    request.setAttribute("result", result);
		    request.getRequestDispatcher("Result.jsp").forward(request, response);
		//구현하세요..
	}
	private void kickCount(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String fname= request.getParameter("fname");
		System.out.println(fname);
		//getServletContext().getRealPath("/"); //context path 가져옴
		String path = getServletContext().getRealPath("/res");   // 중요합니다..채워넣어보세요
		System.out.println(path);
		File f=new File(path, fname); //경로에 파일 연결
		
		int result=Kickboard.execute(f);
		System.out.println(result);
	
		request.setAttribute("result", result);
	    request.getRequestDispatcher("Result.jsp").forward(request, response);	
	}
}
