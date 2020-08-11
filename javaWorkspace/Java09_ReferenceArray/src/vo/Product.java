package vo;
// 상품에 대한 정보를 저장하는 VO 클래스
// VO : Value Object
//필드에 값 넣고 값 빼오고 이런 것만 있음. 이게 VO 클래스.
//VO 객체는 DB와 매핑됨. 나중에 화면단과도 연결됨.
//알고리즘(=기능)이 있으면 안 됨! VO에는 자료만 담아야 한다.
public class Product {
	private String maker;
	private int price;
	private int count;
	
	public Product(String maker, int price, int count) {
		super();
		this.maker = maker;
		this.price = price;
		this.count = count;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}	
	
	public String getProduct() {
		return maker+", "+ price;
	}
}
