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

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받아서
		 * 2. vo 생성.. pvo
		 * 3. DAO 리턴 받아서 updateMember() 호출
		 * 4. 수정된 정보를 반드시 세션에 바인딩
		 * 5. 네비게이션.... update_result.jsp
		 */
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MemberVO pvo = new MemberVO(id, password, name, address);
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) {
				//업데이트는 리턴타입이 없다보니 바인딩 안 하기가 쉬운데 바인딩 꼭 해줘야 함.
				//그래야 수정된 정보로 세션에 오버라이팅된다.
				session.setAttribute("vo", pvo);
			}
			request.getRequestDispatcher("update_result.jsp").forward(request, response);;
		} catch (SQLException e) {
			System.out.println("SQL 예외 발생");
		}
	}

}
