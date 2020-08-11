package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("request");
		try {
			MemberDAOImpl.getInstance().registerMember(new MemberVO(id, password, name, address));
			path = "register_ok.jsp";
		}catch(SQLException e) {
			System.out.println("SQL 예외 발생");
		}
		return new ModelAndView(path);
	}

}
