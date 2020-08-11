package service;
/*
 * 상품을 구입하는 고객, 상점에 입점된 상품에 대한 기능들을 다루는 서비스 클래스...
 */

import vo.Customer;
import vo.Product;

public class OutletStoreService {
	/*
	 * getAllProductMaker() // 특정 고객이 산 모든 상품들의 이름을 반환함
	 * getAllCustomer() // 모든 고객에 대한 정보 반환(주민번호, 이름, 주소 뿐만 아니라 그 사람이 산 물건까지도)
	 * getACustomer() // get a customer. 특정한 고객에 대한 모든 정보를 리턴.
	 * maxPriceProduct() // 최고가 상품의 가격을 받아옴
	 * getMoreAvgProduct() // 특정한 고객이 구입한 상품들 중에서 평균가 이상의 물건을 받아옴. 
	 */
	int prosize = 4;
	int custsize = 3;
	
	public Product[ ] getProduct(Customer vo) {
		return vo.getProducts();
	}
	public String[ ] getAllProductMaker(Customer vo) {
		String[ ] temp = new String[prosize];
		Product[ ] pros=vo.getProducts();
		int cnt = 0;
		for(Product p : pros) {			
			System.out.println(p.getMaker());
			temp[cnt++] = p.getMaker();
		}
		return temp;
	}
	
	
	public Customer[ ] getAllCustomer(Customer[ ] custs) {
		Customer[ ] cs = new Customer[custsize];
		int cnt = 0;
		for(Customer c : custs) {
			cs[cnt++] = c;
		}
		return cs;
	}
	
	public Customer getACustomer(Customer[ ] custs, int ssn) {
		Customer cust = null;
		for(Customer c : custs) {
			if(c.getSsn()==ssn) cust = c;			
		}
		return cust;
	}
	
	public int maxPriceProduct(Customer c) {
		int max = 0;
		System.out.println(c.getName()+" 님이 구매하신 최고가 상품은....");
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			if(p.getPrice()>max) max = p.getPrice();
		}
		return max;
	}
	//추가
	public int avgPrice(Customer c) {
		int total = 0;		
		Product[ ] pros = c.getProducts();
		for(Product p : pros) {
			total += p.getPrice();
		}
		return total/pros.length;
	}
	public Product[ ] getMoreAvgProduct(Customer c) {
		Product[ ] temp = new Product[prosize];
		Product[ ] pros=c.getProducts();
		int cnt = 0;
		for(Product p : pros) {
			if(p.getPrice()>=avgPrice(c)) 
				temp[cnt++] = p;			
		}
		return temp;
	}
}

/*
 * getAllProductMaker()
 * getAllCustomer()
 * getACustomer()
 * maxPriceProduct()
 * getMoreAvgProduct();특정한 고객이 구입한 상품들 중에서
 */

