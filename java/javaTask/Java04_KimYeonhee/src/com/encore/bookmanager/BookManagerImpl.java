package com.encore.bookmanager;

import com.encore.book.Book;
/**
 * 
 * @author KimYeonhee
 * @since JDK 1.8.5
 * @version Start Version level 1.
 * @version 2 :: Singletone ����...
 * @version 3 :: BookManager �������̽� ���ø� ����
 *
 */
public class BookManagerImpl implements BookManager {
	private Book[] bList;
	private int numberOfBooks; // å�� ����
	
	private static BookManagerImpl mgr = new BookManagerImpl();
	
	private BookManagerImpl() {
		bList = new Book[100]; // ������ 100�� �迭. ���� �ִ� �����Ǽ��� 100������ ����.
	}
	
	public static BookManagerImpl getInstance() {
		return mgr;
	}

	/**
	 * 
	 * @return å ��� �迭�� ������ ����å �Ǽ��� ��ȯ��
	 */
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	
	/**
	 * ���ο� ������ �迭 bList�� �߰��ϰ� å �Ǽ��� 1�� �ø�
	 * �߰��Ϸ��� ������ ISBN�� �̹� �����ϰ� �ִ� ������ ISBN�� ���ٸ� �߰����� ����
	 * @param newBook ���� �߰��� Book Ÿ�� å ��ü
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
	 * �迭 bList�� �ִ� ��� b�� null�̶�� ����ħ
	 * @return ��� å ��ü�� ��ҷ� ������ �迭 temp�� ��ȯ��
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
	 * @param isbn ISBN�� �Է���
	 * @return �ش��ϴ� ISBN�� å ��ü�� ��ȯ��
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
	 * @param title å ������ �Է���
	 * @return �ش��ϴ� ������ å ��ü���� �迭�� ��ȯ��
	 */
	public Book[] searchBookByTitle(String title) {
		int count = 0;
		int i = 0;
		Book[] temp1 = new Book[numberOfBooks]; // �ӽ÷� ���� �迭 ����
		for(Book b : bList) {
			if(b != null) {
				if(b.getTitle().contains(title)) {
					temp1[i++] = b;
					count++; 
				}
			}
		}
		Book[] temp2 = new Book[count]; // ��ȯ�� �迭�� ���� ����
		for(int j = 0; j < count; j++) {
			if(temp1[j] != null) {
				temp2[j] = temp1[j]; 
			}
		}
		return temp2;
	}  
		
	
	/**
	 * 
	 * @param publisher ���ǻ縦 �Է���
	 * @return �ش��ϴ� ���ǻ��� å ��ü���� �迭�� ��ȯ��
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
	 * Ÿ���� double�� �޸��Ͽ� Method Overloading ����� ��.
	 * @param price å ������ �Է���
	 * @return �ش��ϴ� ������ å ��ü���� �迭�� ��ȯ��
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
     * @return ��� å�� ������ ���� total�� ��ȯ��
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
	 * @return ��� å�� ������ ���ϰ� ������ŭ ������ ����� ��ȯ��
	 */
	public double getAveragePriceOfBooks() {
		return getSumPriceOfBooks() / numberOfBooks;
	}
}
