package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		String id = request.getParameter("id");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		try {
			boolean flag = dao.idExist(id);
			request.setAttribute("flag", flag);
			path = "idcheck.jsp";
		}catch(SQLException e) {
			System.out.println("SQL 예외 발생");
		}
		
		return new ModelAndView(path);
	}

}
