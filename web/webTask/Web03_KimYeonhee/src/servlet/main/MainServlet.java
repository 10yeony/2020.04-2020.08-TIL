package servlet.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	private ArrayList<String[]> mList = new ArrayList<>();
	private String[] temp;
	
	public void init() throws ServletException {
		path = getInitParameter("path");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			System.out.println("init()..경로를 불러옵니다..."+path);
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				temp = line.split(" ");
				mList.add(temp);
				System.out.println("회원 정보를 가져오는 데 성공하였습니다.");
			}
			br.close();
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		}catch(IOException e) {
			System.out.println("입출력 에러");
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		boolean flag = false;
		out.println("<html><body>");
		for(String[] m : mList) {
			if(m[0].equals(id) && m[1].equals(pwd)) {
				RequestDispatcher rdp = request.getRequestDispatcher("loginSuccess.jsp");
				rdp.forward(request, response);
				flag = true;
				break;
			}
		}
		if(flag==false) {
			RequestDispatcher rdp = request.getRequestDispatcher("error.jsp");
			rdp.forward(request, response);
		}
	}
}
