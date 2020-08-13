package com.encore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.service.BookService;
import com.encore.rest.vo.Book;

@RestController
@RequestMapping("api") //context path 경로에 api 붙이고 가야 함.
public class BookRestController {
	
	@Autowired
	private BookService bookService;
	
	/*
	원칙적으로 Restful은 이름 지을 때 insertBook, deleteBook 이렇게 짓지 않고
	book으로 쓴다. 구분은 Mapping 방식으로 하는 게 맞음.
	그게 Restful 취지를 살린 것. Convention이라서 강제는 아님.
	*/
	
	// http://localhost:8888/rest/api/book
	@GetMapping("/book")
	private ResponseEntity<List<Book>> getAllBook() throws Exception {
		List<Book> books = bookService.getAllBook();
		if(books.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(books, HttpStatus.OK);
	}
	
	@GetMapping("/book/{isbn}")
	public ResponseEntity<Book> getBook(@PathVariable String isbn) throws Exception {
		Book book = bookService.getBook(isbn);
		if(book==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(book, HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<List<Book>> insertBook(@RequestBody Book book) throws Exception{
		boolean check = bookService.insertBook(book);
		if(!check) return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<Book>>(HttpStatus.OK);
	}
	
	@PutMapping("book")
	public ResponseEntity<List<Book>> updateBook(@RequestBody Book book) throws Exception{
		boolean check = bookService.updateBook(book);
		if(!check) return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<Book>>(HttpStatus.OK);
	}
	
	@DeleteMapping("book/{isbn}")
	public ResponseEntity<List<Book>> deleteBook(@PathVariable String isbn) throws Exception{
		boolean check = bookService.deleteBook(isbn);
		if(!check) return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<Book>>(HttpStatus.OK);
	}
}
