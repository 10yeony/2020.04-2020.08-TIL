package com.encore.bookmanager;

import com.encore.book.Book;
/**
 * 
 * @author KimYeonhee
 * @since JDK 1.8.5
 * @version Start Version level 1.
 * @version 2 :: Singletone 적용...
 * @version 3 :: BookManager 인터페이스 템플릿 제공
 *
 */
public class BookManagerImpl implements BookManager {
	private Book[] bList;
	private int numberOfBooks; // 책의 개수
	
	private static BookManagerImpl mgr = new BookManagerImpl();
	
	private BookManagerImpl() {
		bList = new Book[100]; // 사이즈 100의 배열. 도서 최대 보유권수는 100권으로 지정.
	}
	
	public static BookManagerImpl getInstance() {
		return mgr;
	}

	/**
	 * 
	 * @return 책 목록 배열로 도서관 소장책 권수를 반환함
	 */
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	
	/**
	 * 새로운 도서를 배열 bList에 추가하고 책 권수를 1권 늘림
	 * 추가하려는 도서의 ISBN이 이미 보유하고 있는 도서의 ISBN과 같다면 추가하지 않음
	 * @param newBook 새로 추가할 Book 타입 책 객체
	 */
	public void insertBook(Book newBook) {
		for(int i = 0; i < bList.length; i++) {
			if(bList[i] == null) {
					bList[i] = newBook;
					numberOfBooks++;
					break;
			}
		}
	}
	
	/**
	 * 배열 bList에 있는 요소 b가 null이라면 지나침
	 * @return 모든 책 객체를 요소로 가지는 배열 temp를 반환함
	 */
	public Book[] getAllBook() {
		Book[] temp = new Book[numberOfBooks];
		int i = 0;
		for(Book b : bList) {
			if(b == null) {
				continue;
			}
			else if(b.equals(bList[i])) {
				temp[i] = b;
			}
			i++;
		}
		return temp;
	}
	
	/**
	 * 
	 * @param isbn ISBN을 입력함
	 * @return 해당하는 ISBN의 책 객체를 반환함
	 */
	public Book searchBook(String isbn) {
		Book temp = null;
		for(Book b : bList) {
			if(b != null) {
				if(b.getIsbn().equals(isbn)) {
					temp = b;
				}
			}
		}
		return temp;
	}
	
	/**
	 * 
	 * @param title 책 제목을 입력함
	 * @return 해당하는 제목의 책 객체들의 배열을 반환함
	 */
	public Book[] searchBookByTitle(String title) {
		int count = 0;
		int i = 0;
		Book[] temp1 = new Book[numberOfBooks]; // 임시로 담을 배열 생성
		for(Book b : bList) {
			if(b != null) {
				if(b.getTitle().contains(title)) {
					temp1[i++] = b;
					count++; 
				}
			}
		}
		Book[] temp2 = new Book[count]; // 반환할 배열을 따로 만듦
		for(int j = 0; j < count; j++) {
			if(temp1[j] != null) {
				temp2[j] = temp1[j]; 
			}
		}
		return temp2;
	}  
		
	
	/**
	 * 
	 * @param publisher 출판사를 입력함
	 * @return 해당하는 출판사의 책 객체들의 배열을 반환함
	 */
	public Book[] searchBookByPublisher(String publisher) {
		int count = 0;
		int i = 0;
		Book[] temp1 = new Book[numberOfBooks];
		for(Book b : bList) {
			if(b != null) {
				if(b.getPublisher().contains(publisher)) {
					temp1[i++] = b;
					count++;
				}
			}
		}
		Book[] temp2 = new Book[count];
		for(int j = 0; j < count; j++) {
			if(temp1[j] != null) {
				temp2[j] = temp1[j];
			}
		}
		return temp2;
	}
	
	/**
	 * 타입을 double로 달리하여 Method Overloading 기법을 씀.
	 * @param price 책 가격을 입력함
	 * @return 해당하는 가격의 책 객체들의 배열을 반환함
	 */
	public Book[] searchBook(double price) {
		int count = 0;
		int i = 0;
		Book[] temp1 = new Book[numberOfBooks];
		for(Book b : bList) {
			if(b != null) {
				if(b.getPrice() == price) {
					temp1[i++] = b;
					count++;
				}
			}
		}
		Book[] temp2 = new Book[count];
		for(int j = 0; j < count; j++) {
			temp2[j] = temp1[j];
		}
		return temp2;
	}
	
    /**
     * 
     * @return 모든 책의 가격을 합한 total을 반환함
     */
	public double getSumPriceOfBooks() {
		int total = 0;
		for(Book b : bList) {
			if(b != null) total += b.getPrice();
		}
		return total;
	}
	
	/**
	 * 
	 * @return 모든 책의 가격을 합하고 개수만큼 나눠서 평균을 반환함
	 */
	public double getAveragePriceOfBooks() {
		return getSumPriceOfBooks() / numberOfBooks;
	}
}
