package service;

import vo.Product;

/*
 * ProductStore에 있는 다양한 상품들을 다루는 기능을 모아놓은 서비스 클래스...
 * 이 클래스에서 다루는 기능들....
 * 1)다양한 상품들의 maker를 출력
 * 2)상품들의 총 금액을 리턴
 * 3)상품들의 평균가를 리턴
 * 4)특정 금액 이상되는 상품의 정보를 출력
 * 5)특정회사 상품을 리턴하는 기능
 */
public class ProductStoreService {
	public void printAllProductMaker(Product[ ] pros) {
		// 모든 상품에 대한 인자값. Product[ ] pros
		// vo 패키지 product에서 메소드 인자값으로 hasing함.
		for(Product pro : pros) System.out.print(pro.getMaker()+" ");	
		// 엄밀히 따지면 출력은 여기에서 하지 않고 Test에서 함. Service는 처리한 결과를 Test에게 넘겨줄 뿐임.
	}
	
	public int getTotalPrice(Product[ ] pros) {
		int total = 0;
		for(Product pro : pros)	total += pro.getPrice();		
		return total;
	}
	
	public int getAvgPrice(Product[ ] pros) {
		return getTotalPrice(pros)/pros.length;
		// 위에꺼를 호출해서 재사용함.
		// 반복되는 로직은 미리 만들어놓고 거기에 대한 것은 다시 만들지 않고 호출해서 씀.
	}
	
	public void printMorePrice(Product[ ] pros, int price) {
		for(Product pro : pros) {
			if(pro.getPrice()>=price) 
				System.out.println(pro.getMaker()+", "+pro.getPrice());			
		}
	}
	
	public Product[ ] getCertainMaker(Product[ ] pros, String maker) {
		Product[ ] products = new Product[pros.length];
		int idx = 0;
		for(Product pro : pros) {
			if(pro.getMaker().equals(maker)) 
				products[idx++]=pro;				
		}// pros에서 HP가 2개밖에 없으므로 {HP, HP, null, null}이 되고 테스트에서 실행시키면 에러가 뜸.
		// 그래서 테스트에서 for문 활용해서 출력
		return products;
	}
	
}













