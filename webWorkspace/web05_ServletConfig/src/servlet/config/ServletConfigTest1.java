package servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String name, addr;
	
	@Override
	public void init() throws ServletException {
		System.out.println("생성자 호출.....");
		
		//ServletConfig로부터 상속하므로 그냥 쓰면 됨
		//컨테이너 차원에서 값을 받아와서 필드 초기화
		name = getInitParameter("name");
		addr = getInitParameter("addr");
		System.out.println(name+","+addr);
	}
	
    public ServletConfigTest1() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("do Procoess...");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<h2>A Servlet Instance Initialization... Using ServletConfig</h2><p>");
			
			out.println("당신의 이름 : "+name+"<br/>");
			out.println("당신이 사는곳 : "+addr+"<br/>");
			
			out.close();
	}
}
