package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberVO vo;
	private MemberDAOImpl dao = MemberDAOImpl.getInstance();
       
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
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		vo = new MemberVO(id, password, name, address);
		dao.registerMember(vo);
		
		//request.getRequestDispatcher("/AMS").forward(request, response);
		response.sendRedirect("AMS?name="+name);
		//매핑된 이름으로 써줘야 함! 이러면 리다이렉트 되어도 name 값 가지고 감.
		//이 상황에서는 리다이렉트가 더 적절함. 
		//최종 목적지는 allShow.jsp인데 AllMemberServlet에서 가야 하므로 리다이렉트로 클라이언트로 응답했다가
		//클라이언트가 AllMemberServlet로 요청하고 AllMemberServlet에서 바인딩하고 거기에서 포워딩해서 allShow.jsp로 가서 응답함
	}

}