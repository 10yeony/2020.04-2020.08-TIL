package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class IdListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "step1_idList.html";
		ArrayList<MemberVO> list = new ArrayList<>();
		try {
			list = MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path = "show_idList.jsp";
		}catch(SQLException e) {
			System.out.println("SQL 예외 발생");
		}
		return new ModelAndView(path);
	}

}
