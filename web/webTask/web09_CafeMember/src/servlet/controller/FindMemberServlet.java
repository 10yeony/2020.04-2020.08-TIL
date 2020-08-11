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
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			
		}
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		vo = dao.findByIdMember(id);
		if(vo == null) {
			request.getRequestDispatcher("find_fail.jsp").forward(request, response);
		}else {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("find_ok.jsp").forward(request, response);
		}
	}

}
