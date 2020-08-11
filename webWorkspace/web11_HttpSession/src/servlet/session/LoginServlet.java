package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 세션을 하나 받아온다... request.getSession()
		 *    jsessionID값 콘솔, 브라우저로 찍어본다.
		 * 2. 폼에 입력된 값을 가지고 vo객체 생성... MemberVO
		 * 3. 세션에 바인딩...
		 * 4. 네비게이션...
		 *    A href ='ProductServlet' //진짜로 같은 세션을 쓰는지 확인하기 위함.
		 */
		PrintWriter out = response.getWriter();
		//HttpSession session = request.getSession(true);
		//최초로 만든 세션일 경우 true, 기존의 세션을 갖다 쓸 때는 false.
		//그런데 서버가 쿠키 정보 열어서 자기가 알아서 true, false로 만들어줌. 우리가 해줄 필요 X.
		HttpSession session = request.getSession();
		
		out.println("jsessionID : "+session.getId()+"<br/>");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		session.setAttribute("vo", pvo);
		out.println("<hr>");
		
		out.println("<a href=ProductServlet>ProductServlet...두번째 요청하는 서블릿으로 이동함..</a>");
	}
}
