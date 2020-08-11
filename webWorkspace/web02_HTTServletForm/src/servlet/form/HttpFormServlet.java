package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*
     service(request, response);
     WAS가 호출한다. 
         클라이언트가 요청을 하면 호출함.
     request, response 객체가 생성...
         쓰레드가 생성
     */

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 한글처리...양방향
		 * 폼에 입력된 모든 데이터 받아서
		 * 웹 브라우저로 출력
		 */
		
		//한글처리부터 하고 폼 값 받아와야 한다.
		//더 정확히는 PrintWriter 리턴받기 전에 해야 한다.
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		String[] menus = request.getParameterValues("menu");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>정보를 출력합니다....</h2>");
		out.println("<li>당신의 아이디 "+id+"</li>");
		out.println("<li>당신의 패스워드 "+pass+"</li>");
		out.println("<b>당신이 좋아하는 음식들입니다.</b><br/>");
		String menu = "";
		for(int i=0; i<menus.length; i++) {
			menu += menus[i]+" ";
		}
		out.println(menu);
		out.println("</body></html>");
		out.close();
	}

}
