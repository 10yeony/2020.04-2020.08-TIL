package servlet.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.BookDAOImpl;
import servlet.model.BookVO;

public class BookRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		System.out.println("폼값을 받아옵니다...");
		String isbn = request.getParameter("isbn1")+"-"+
					request.getParameter("isbn2")+"-"+
					request.getParameter("isbn3");
		String title = request.getParameter("title");
		String catalogue = request.getParameter("catalogue");
		String nation = request.getParameter("nation");
		String publishDate = request.getParameter("publishDate");
		if(publishDate.equals("")) publishDate = "0000-00-00";
		String publisher = request.getParameter("publisher");
		if(publisher.equals("")) publisher = ".";
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String currency = request.getParameter("currency");
		String description = request.getParameter("description");
		if(description.equals("")) description = ".";
		BookVO vo = new BookVO(isbn, title, catalogue, nation, publishDate, 
						publisher, author, price, currency, description);
		try {
			System.out.println("BookVO 객체를 DB에 저장");
			BookDAOImpl.getInstance().registerBook(vo);
		} catch (SQLException e) {
			
		}
		
		System.out.println("페이지를 이동합니다.");
		request.getRequestDispatcher("book/bookResult.jsp").forward(request, response);
	}

}
