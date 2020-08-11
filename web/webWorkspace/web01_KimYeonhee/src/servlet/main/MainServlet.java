package servlet.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		out.println("<html><body>");
		if(id.equals("encore") && pwd.equals("1234")) {
			out.println("<p><a href=LS?id="+id+"&pwd="+pwd+">입장</a></p>");
			out.println("</body></html>");
		}else {
			out.println("<html><body>");
			out.println("<p><a href=LE>입장</a></p>");
			out.println("</body></html>");
		}
	}

}
