package vo;
/*
 * 상품을 구입하는 소비자에 대한 정보를 담고 있는 클래스..
 * 상품을 구매하는 고객
 * 상품을 구매하지 않은 고객
 * Product <------ Customer // 고객이 상품을 가지고 고객이 상품에 의존함.
 * ========================
 * 
 */
public class Customer {
	//생성자 주입
	private int ssn; // social secret number 주민등록번호
	private String name;
	private String address;
	
	//setter 주입
	// private Product products; <- 이렇게 하면 여러 가지 상품을 담을 수 없으므로 배열로 필드를 선언해야 함.
	private Product[] products;
	public Customer(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	// 주입한 setter를 setProducts -> buyProducts (더 현실세계와 가깝게 직관적으로)
	public void buyProducts(Product[] products) {
		this.products = products;
	}
	public int getSsn() {
		return ssn;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public Product[] getProducts() {
		return products;
	}
	
	public String getCustomer() {
		return ssn+", "+name+" , "+address;
	}
}
















