package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import servlet.model.BookDAOImpl;
import servlet.model.BookVO;
import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "intro.html";
		if(command.equals("login")) {
			path = login(request, response);
		}else if(command.equals("bookRegister")) {
			path = bookRegister(request, response);
		}else if(command.equals("showAllBook")) {
			path = showAllBook(request, response);
		}else if(command.equals("searchBook")) {
			path = searchBook(request, response);
		}else if(command.equals("findDesc")) {
			path = findDesc(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);;
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		try {
			UserVO rvo = UserDAOImpl.getInstance().login(userId, password);
			if(rvo!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("rvo", rvo);
				path = "loginSuccess.jsp";
			}else {
				path = "error.jsp";
			}
		} catch (SQLException e) {
			System.out.println("SQL 예외 발생");
		}
		return path;
	}

	protected String bookRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
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
			System.out.println("SQL 예외 발생");
		}
		System.out.println("페이지를 이동합니다.");
		path = "book/bookResult.jsp";
		return path;
	}

	protected String showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		System.out.println("ArrayList<BookVO>를 가져와서 세션에 바인딩");
		try {
			request.getSession().setAttribute("list", BookDAOImpl.getInstance().showAllBook());
			path = "book/bookList.jsp";
		} catch (SQLException e) {
			System.out.println("SQL 예외 발생");
		}
		return path;
	}
	protected String searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		String option = request.getParameter("option");
		String content = request.getParameter("content");
		if(option.equals("전체")) {
			showAllBook(request, response);
		}
		BookDAOImpl dao = BookDAOImpl.getInstance();
		try {
			if(option.equals("도서명")){
				request.getSession().setAttribute("list", dao.findByTitleBook(content));
			}else if(option.equals("출판사")){
				request.getSession().setAttribute("list", dao.findByPublisherBook(content));
			}else if(option.equals("가격")) {
				request.getSession().setAttribute("list", dao.findByPriceBook(content));
			}
		}catch(SQLException e){
			System.out.println("SQL 예외 발생");
		}
		path = "book/bookList.jsp";
		return path;
	}
		
	protected String findDesc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		String isbn = request.getParameter("isbn");
		PrintWriter out = response.getWriter();
		try {
			BookVO vo = BookDAOImpl.getInstance().findByIsbnBook(isbn);
			String result = "Book 상세정보 출력 - 제목 : "+vo.getTitle()+", 출판사 : "+vo.getPublisher()+", 저자 : "+vo.getAuthor();
			request.setAttribute("result", result);
			path = "book/bookDesc.jsp";
		} catch (SQLException e) {
			System.out.println("SQL 예외 발생");
		}
		return path;
	}
}
