package servlet.model;

import java.util.Arrays;

public class Book {
	private int[] num;
	private String title;
	private String kind;
	private String nation;
	private String date;
	private String publisher;
	private String author;
	private int price;
	private String content;
	
	public Book() {}
	public Book(int[] num, String title, String kind, String nation, String date, String publisher, String author,
			int price, String content) {
		super();
		this.num = num;
		this.title = title;
		this.kind = kind;
		this.nation = nation;
		this.date = date;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.content = content;
	}
	
	public int[] getNum() {
		return num;
	}
	public void setNum(int[] num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Book [num=" + Arrays.toString(num) + ", title=" + title + ", kind=" + kind + ", nation=" + nation
				+ ", date=" + date + ", publisher=" + publisher + ", author=" + author + ", price=" + price
				+ ", content=" + content + "]";
	}
}
