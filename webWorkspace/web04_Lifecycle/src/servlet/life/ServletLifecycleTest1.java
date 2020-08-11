package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//같은 디렉토리에 WAS가 없으므로 public을 안 붙이면 WAS가 접근을 못함.
//WAS는 바깥에 있음. WAS가 서블릿 객체 생성의 주체!
public class ServletLifecycleTest1 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int count = 0; //서블릿이 죽을 때까지 이 필드 살아있게 됨.
	
	//이런 메소드들을 콜백 메소드라고 한다.
    public ServletLifecycleTest1() {
    	System.out.println("1. serviceLifecycleTest1 생성자....call..by container");
    }
    
    public void init() throws ServletException{
    	System.out.println("2. init......call..by container");
    }
    
    public void destroy() {
    	System.out.println("4. destroy.....call...by container");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service.......call..by container");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//웹 브라우저로 출력
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>LifeCycle CallBack Method...</h3>");
		out.println("<b>Count :: </b>"+ ++count);
		out.println("</body></html>");
		
		out.close();
	}

}
