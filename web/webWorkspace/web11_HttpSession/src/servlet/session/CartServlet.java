package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *1. 기존 세션을 하나 받아온다
		 *2. jsessionid, vo, pvo 정보를 각각 받아와서 출력
		 *~마지막 페이지라서 로그아웃해야 함. 로그아웃하려면 세션이 있어야 함.~
		 *3. 현재 세션에 바인딩된 정보가 있다면 --- 세션을 죽인다... 
		 *4. 현재 세션에 바인딩된 정보가 없다면 --- 처음부터 login.html
		 */
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("<h3>"+session.getId()+"<br/>");
		out.println("vo :: "+session.getAttribute("vo")+"<br/>");
		out.println("Product Information :: "+session.getAttribute("pvo")+"</h3>");
		
		if(session.getAttribute("vo") !=null) {
			//세션을 죽임. 로그아웃함.
			session.invalidate();
			
			out.println("<script>");
			out.println("alert('로그아웃 되셨습니다...!!')");
			out.println("location.href='login.html'"); //스크립트에서 페이지 이동할 때 location.href(중요)
			out.println("</script>");
		}else {
			response.sendRedirect("login.html");
		}
	}

}
