package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * <servlet>
 * 	<servlet-name>DispatcherServlet</servlet-name>
 *  <servlet-class>servlet.controller.DispatcherServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * 	<servlet-name>DispatcherServlet</servlet-name>
 *  <url-pattern>front.do</url-pattern>
 * </servlet-mapping>
 */
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet(urlPatterns="/front.do",loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청이 어디에서 들어온 요청인지를 .....command값 받는다
		String command =request.getParameter("command");
		String path = "index.jsp";
		
		if(command.equals("register")) {
			path = register(request,response);
		}else if (command.equals("find")) {
			path = find(request,response);
		}else if (command.equals("idcheck")) {
			path = idcheck(request,response);
		}else if (command.equals("update")) {
			path = update(request,response);
		}else if (command.equals("login")) {
			path = login(request,response);
		}else if (command.equals("logout")) {
			path = logout(request,response);
		}else if (command.equals("allmember")) {
			path = allmember(request,response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);	
	}//doProcess
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo  = new MemberVO(id, password, name, address);
		String path = "register_ok.jsp";
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);			
		}catch(SQLException e) {
			
		}
		return path;
	}
	protected String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		try {
			MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo);
				path = "find_ok.jsp";
			}			
		}catch(SQLException e) {
			
		}
		return path;
		
	}
	protected String idcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "idcheck.jsp";
		String id = request.getParameter("id");
		try {
			boolean flag=MemberDAOImpl.getInstance().idExist(id);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher(path).forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		return path;
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		String path = "index.jsp";
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			HttpSession session  = request.getSession();
			if(session.getAttribute("vo") !=null) {
				session.setAttribute("vo", pvo); //중요
				path = "update_result.jsp";
			}
			
			request.getRequestDispatcher(path).forward(request, response);
		}catch(Exception e) {
			
		}		
		return path;
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path ="login_fail.jsp";
		try {
			MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			
			if(rvo !=null ) {
				session.setAttribute("vo", rvo);
				path ="login_result.jsp";
				System.out.println("JSESSIONID :: "+session.getId());				
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (SQLException e) {			
		}
		return path;
	}
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃 로직을 작성....invalidate()
		HttpSession session = request.getSession();
		String path ="index.jsp";	
		if(session.getAttribute("vo") !=null) {//로그인한 상태라면...
			session.invalidate();
			path ="logout.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		return path;
	}
	protected String allmember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.jsp";
		try {
			ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			path = "allView.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}catch(SQLException e) {
			
		}
		return path;
	}
}











