package com.encore.rest.service;

import java.util.List;

import com.encore.rest.vo.Book;

public interface BookService {
	/* 데이터 가공하는 곳이므로 select만 있는 게 나음.
	다 있더라도 전혀 관련 없는 delete는 빼는 게 맞음.
	
	그런데 그렇게 원리 원칙대로 하다 보니 
	Controller가 Service 뿐만 아니라 DAO도 Autowired 해줘야 함.
	
	그러니 원리 원칙은 알고 있되, 안 빼고 쓰겠음. */
	
	List<Book> getAllBook() throws Exception;
	Book getBook(String isbn);
	boolean insertBook(Book book) throws Exception;
	boolean updateBook(Book book) throws Exception;
	boolean deleteBook(String isbn) throws Exception;
}
