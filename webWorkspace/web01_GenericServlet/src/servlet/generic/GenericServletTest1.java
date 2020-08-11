//자바가 아니라 서블릿. JVM에서 실행되는 거 아니므로 main 아님.
//컴파일은 JVM에서 함

package servlet.generic;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class GenericServletTest1 extends GenericServlet{
	/*
	클라이언트가 요청을 하면 호출되는 메소드 입니다.
	이떄 클라이언트의 요청정보를 servletRequest에 저장합니다. ----- broker에서 했던 Command 객체와 동일
	요청을 수행한 후 응답할 정보를 ServletResponse에 저장합니다. --- broker에서 했던 Command 객체의 Result와 동일
	 */
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//요청을 받았다는 가정하에 바로 응답을 보내보겠습니다. (클라이언트의 브라우저로 응답해야합니다.)
		PrintWriter out =res.getWriter();//printWriter를 얻어와야합니다.응답할 정보를 찾으려면 res에서 찾아야합니다.
		out.println("<html><body bgcolor='yellow'>");//브라우저로 응답해서 출력합니다. html로 뿌립니다.그래서 html tag를 넣어야 합니다.
		out.println("<h2>hellow~~~ GenericServlet!!!</h2>");
		out.println("</body></html>");
		out.close();
	}
}
//http://127.0.0.1:8888/web01_GenericServlet/GenericServletTest1
//저 요청이 있으면, service가 받아서 응답합니다.
// servlet 작성- server 가동-> context단위로 배포-> 브라우저 열어서 요청합니다. -> 서버상에서 돌고 있는 service가 받아서 응답합니다.
//404가 뜹니다. 경로 문제, file문제가 될 수 있습니다.