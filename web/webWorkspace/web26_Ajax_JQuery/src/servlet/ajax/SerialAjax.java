package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SerialAjax")
public class SerialAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> map = new HashMap<>();
    
	@Override
	public void init() throws ServletException {
		map.put("ajax", "Anne"); //id가 key, 이름이 value로 매핑... 디비라고 생각하자..
		map.put("encore", "Stella");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		
		//회원가입 폼이라면
		if(command.equals("register")) {
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			out.print(addr+"에 사는 "+name+"님!!, 회원가입 성공!!!");
		}else if(command.equals("idCheck")) {
			String id = request.getParameter("id");
			if(map.get(id)==null) {
				out.print(false); //폼으로 받은 아이디가 DB에 없다면...사용 가능...
			}else {
				out.print(true);
			}
		}
	}

}
