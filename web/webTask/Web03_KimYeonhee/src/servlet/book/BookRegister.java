package servlet.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;

public class BookRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Book bk;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		System.out.println("폼값을 받아옵니다...");
		int[] num = {
				Integer.parseInt(request.getParameter("num1")),
				Integer.parseInt(request.getParameter("num2")),
				Integer.parseInt(request.getParameter("num3"))
		};
		String title = request.getParameter("title");
		String kind = request.getParameter("kind");
		String nation = request.getParameter("nation");
		String date = request.getParameter("date");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String content= request.getParameter("content");
		
		System.out.println("bk 생성");
		bk = new Book(num, title, kind, nation, date, publisher, author, price, content);
		
		System.out.println("bk 객체를 ServletRequest에 저장");
		request.setAttribute("bk", bk);
		
		System.out.println("페이지를 이동합니다.");
		RequestDispatcher rdp = request.getRequestDispatcher("bookResult.jsp");
		rdp.forward(request, response);
	}

}
