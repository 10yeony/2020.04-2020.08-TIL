package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			dao.updateMember(new MemberVO(id, password, name, address));
			path = "update_result.jsp";
		}catch(SQLException e) {
			System.out.println("SQL 예외 발생");
		}
		return new ModelAndView(path);
	}

}
