package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

public class RegisterServlet extends HttpServlet {
	//그냥 생기는 것 고유한 number
	private static final long serialVersionUID = 1L;
	private ServletContext context;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...
		/*
		 * 1. 양방향 한글처리
		 * 2. 폼값 받아서
		 * 3. vo객체 생성
		 * 4. DAO 리턴 받고... 받았다 치고
		 * 5. 비즈니스로직 호출...했다 치고
		 * 6. 객체 바인딩... ServletContext에
		 * 7. 페이지 이동....안 배웠으니깐...그냥 a 태그로 이동만 하자
		 * 
		 */
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(name, age, addr);
		
		context = getServletContext(); //상속받은 것이므로 참조변수 없이 그냥 쓸 수 있음.
		
		context.setAttribute("vo", vo); //참조변수와 동일한 이름으로 가는 게 좋음.
		
		//JSP로 바꾸기
		out.println("<a href='ViewServlet'>ViewServlet 결과 확인하러 가기</a>");
		//out.println("<a href='result.jsp'>결과 확인하러 가기</a>");
		out.close();
	}

}
