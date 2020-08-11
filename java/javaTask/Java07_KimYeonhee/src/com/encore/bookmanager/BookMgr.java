package com.encore.bookmanager;

import java.util.ArrayList;

import com.encore.book.Book;

/*
 * BookManager �������̽��� �پ��� Book ��ü���� �ڵ鸵�ϴ� ���ø� ����� ������ �ִ�.
 */
public interface BookMgr {
	// ���� ������� ������ �ʰ� ������ ���ø��� ������ Ŀ���͸����� �Ѵ�.
	// �� �۾��� �� ȸ���ؼ� method identify�� ����. ���� ������ ��
	// �������̽��� ���� ������ ǥ��ȭ�� �Ծ�
	// �������̽� �ϳ� �ָ� ���� Ÿ�� ���� �ϰ� �̷� ��� ���ص� ��. 
	
	void addBook(Book nBook);
	ArrayList<Book> getAllBook();
	Book searchBookByIsbn(String isbn);
	ArrayList<Book> searchBookByTitle(String title);
	ArrayList<Book> onlySearchBook();
	ArrayList<Book> onlySearchMagazine();
	ArrayList<Book> magazineOfThisYearInfo(int year);
	ArrayList<Book> searchBookByPublisher(String publisher);
	ArrayList<Book> searchBookByPrice(int price);
	int getTotalPrice();
	int getAvgPrice();

}
