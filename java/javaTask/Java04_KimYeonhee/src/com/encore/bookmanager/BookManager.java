package com.encore.bookmanager;

import com.encore.book.Book;

/*
 * BookManager �������̽��� �پ��� Book ��ü���� �ڵ鸵�ϴ� ���ø� ����� ������ �ִ�.
 */
public interface BookManager {
	// ���� ������� ������ �ʰ� ������ ���ø��� ������ Ŀ���͸����� �Ѵ�.
	// �� �۾��� �� ȸ���ؼ� method identify�� ����. ���� ������ ��
	// �������̽��� ���� ������ ǥ��ȭ�� �Ծ�
	// �������̽� �ϳ� �ָ� ���� Ÿ�� ���� �ϰ� �̷� ��� ���ص� ��. 
	int getNumberOfBooks();
	void insertBook(Book newBook);
	Book[] getAllBook();
	Book searchBook(String isbn);
	Book[] searchBookByTitle(String title);
	Book[] searchBookByPublisher(String publisher);
	Book[] searchBook(double price);
	double getSumPriceOfBooks();
	double getAveragePriceOfBooks();
}
