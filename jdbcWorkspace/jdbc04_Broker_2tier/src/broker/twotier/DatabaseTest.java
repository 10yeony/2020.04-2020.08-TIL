package broker.twotier;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {
		Database db = new Database("127.0.0.1");
		//db.addCustomer(new CustomerRec("123-123", "아이유", "판교")); //회원가입
		//db.deleteCustomer("123-123"); //회원탈퇴
		//db.updateCustomer(new CustomerRec("123-123", "아이유", "분당")); //회원정보 수정
		/*for(StockRec sr : db.getAllStocks()) {
			System.out.println(sr.toString());
		}*/ //모든 주식 정보 가져오기
		//db.buyShares("123-123", "JDK", 50); //주식 매수
		//db.sellShares("123-123", "JDK", 1); //주식 매도
		//System.out.println(db.getPortfolio("123-123").toString()); //특정 개인이 보유한 주식 모두 가져오기
		System.out.println(db.getCustomer("123-123").toString()); // 특정 개인 정보 가져오기
		//System.out.println(db.getAllCustomers().toString()); //모든 고객 정보 가져오기(toString())
		/*for(CustomerRec cr : db.getAllCustomers()) {
			System.out.println(cr.toString());
		}*/ //모든 고객 정보 가져오기(향상된 for문)
	}
	//db.getCustomer()와 db.getAllCustomers()에서 
	//db.getPortfolio()을 호출해야 하는데 그러다 보니 Database Connection이 계속 생김.
	//특히 db.getAllCustomers()에서는 while문 돌리다 보니 그 때마다 연결됨. 해결 방법 없는지...

}
