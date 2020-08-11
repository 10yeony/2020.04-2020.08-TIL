package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;
import servlet.model.MemberDAOImpl;

public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAOImpl dao = MemberDAOImpl.getInstance();
	private MemberVO vo;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			vo = dao.findByIdMember(id);
		}catch(SQLException e) {
			
		}
		if(vo != null) {
			request.setAttribute("vo", vo);
			path = "find_ok.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
