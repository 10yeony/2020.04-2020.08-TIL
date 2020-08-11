package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// html에서 form method=post로 했는데 서블릿에서 doGet() 쓰면 에러남. 확인해볼 것.
public class HttpFormServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//폼에 값을 한꺼번에 다 가져옴.
		out.println("<html><body><h2>폼에 입력된 값들을 출력합니다...</h2>");
		Enumeration<String> en = request.getParameterNames(); 
		//보통 getParameterNames 잘 안 씀.
		//언제 쓰냐? => 내가 폼의 이름(key의 이름)을 모를 때
		while(en.hasMoreElements()) {
			String name = en.nextElement(); //Enumeration에서 key가 나옴.
			out.println("<li>"+name+" : "+request.getParameter(name)+"</li><br/>");
			//menu는 항목이 여러개가 있어서 첫번째 값만 출력된다.
		}
		
		String str[] = request.getParameterValues("menu");
		out.println("<b>당신이 좋아하는 음식들입니다.</b><br/>");
		String menu = "";
		for(int i=0; i<str.length; i++) {
			menu += str[i]+" ";
		}
		out.println(menu);
		out.close();
	}

}
