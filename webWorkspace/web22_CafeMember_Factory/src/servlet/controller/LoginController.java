package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		MemberVO vo = null;
		try {
			vo = MemberDAOImpl.getInstance().login(id, password);
			if(vo!=null) {
				session.setAttribute("vo", vo);
				path = "login_result.jsp";
			}
		}catch(SQLException e) {
			System.out.println("SQL 예외 발생");
		}
		return new ModelAndView(path);
	}

}
