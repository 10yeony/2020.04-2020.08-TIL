package servlet.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		try {
			UserVO rvo = UserDAOImpl.getInstance().login(userId, password);
			if(rvo!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("rvo", rvo);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			}else {
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			
		}
	}
}
