package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받아온다.
		 * 2. dao 리턴받고 biz 로직 호출
		 * 3. 세션을 받아온다.
		 * 4. 결과값 바인딩... 세션...(로그인은 세션에!!)
		 *    이때 jsessionid 값도 찍어본다. 콘솔에...
		 * 5. 페이지 이동... login_result.jsp
		 */
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			if(rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("jssesionid : "+session.getId());
				request.getRequestDispatcher("login_result.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			
		}
	}

}
