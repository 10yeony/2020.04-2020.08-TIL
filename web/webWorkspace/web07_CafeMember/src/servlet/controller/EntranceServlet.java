package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;
/*
 * 회원 가입하면... 정보를 바탕으로
 * MemberVO를 생성.....ArrayList에 추가
 * 회원 가입을 5명이.... MemberVO 5개 생성
 * ArrayList 사이즈는 5
 * ArrayList를 통째로 ServletContext에 바인딩...
 */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//동기화처리가 된 리스트를 받아옴. 회원가입시 충돌을 막기 위해.
    List<MemberVO> list = Collections.synchronizedList(new ArrayList<>());
    private ServletContext context;
    
	public void init() throws ServletException {
		/*context = getServletContext();
		System.out.println("ServletContext의 주소 :: "+context);
		
		context.setAttribute("list", list);
		System.out.println("ServletContext에 카페 입장명단을 저장할 List를 미리 바인딩 합니다...");*/
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		request.setAttribute("list", list);
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		System.out.println("폼값을 받아옵니다...");
		
		MemberVO vo = new MemberVO(name, age, addr);
		System.out.println("2. MemberVO 생성");
		
		list.add(vo);
		System.out.println("3. MemberVO를 List를 저장..."); //request에 바인딩된 List에 VO가 저장.
		
		out.println(name +" 님이 카페에 입장하셨습니다..<p>");
		System.out.println(name+" 님이 카페에 입장하셨습니다");
		
		//out.println("<a href=viewMember.jsp?name="+name+">viewMember.jsp 페이지로 이동합니다.</a>");
		//네비게이션(페이지 이동)
		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp"); 
		//name 안 가지고 가져도 됨. 그대로 가기 때문.
		rdp.forward(request, response); //이거해줘야 넘어감.
		
		out.println("페이지 이동 시켰습니다... forward");
		//이 부분 안 돌아감. 포워딩을 하면 JSP가 바로 응답하기 때문에 이거 안 뜸.
		//rdp.include(request, response); 해주고 적어주면 뜸.
	}

}
