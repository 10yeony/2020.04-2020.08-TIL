package servlet.redirect;

import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * checkbox를 선택하지 않으면...error 페이지로 이동...redirect 방법
		 * 그렇지 않은 경우 forwarding으로 내용을 전달함
		 */		
		String check = request.getParameter("choose");
		if(check==null) {//선택하지 않은 경우...error page
			response.sendRedirect("error/error.html");
		}else {//선택한 경우
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		}
		
	}

}
