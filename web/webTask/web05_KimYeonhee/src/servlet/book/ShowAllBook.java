package servlet.book;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.BookDAOImpl;

public class ShowAllBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ArrayList<BookVO>를 가져와서 세션에 바인딩");
		try {
			request.getSession().setAttribute("vo", BookDAOImpl.getInstance().showAllBook());
			request.getRequestDispatcher("book/bookList.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}
}
