package jdbc.test;

import java.sql.SQLException;

import config.ServerInfo;
import jdbc.dao.impl.CustomerDAOImpl;
import jdbc.vo.Customer;

public class CustomerDAOTest {
	//static 초기화 블락...
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading OK!!....");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail...");
		}
	}
	public static void main(String[] args) throws SQLException {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		//메소드 호출...할 때 값 입력...해서 하나씩 완성해 나가보세요.
		//dao.registerCustomer(new Customer("abc","1234","김연경","여의도"));
		//dao.registerCustomer(new Customer("def","5678","김혜수","인천"));
		//dao.registerCustomer(new Customer("ghi","9876","김연아","부천"));
		//dao.updateCustomer(new Customer("abc","1258","김연경","서초동"));
		//dao.deleteCustomer("ghi");
		//System.out.println(dao.getCustomer("def").toString());
		
		/*for(Customer c : dao.getAllCustomer()) {
			System.out.println(c.toString());
		}*/
		Customer cs1 = new Customer("abc","1258","김연경","여의도");
		System.out.println("회원정보 : " + dao.login(cs1).toString());
		Customer cs2 = new Customer("abc","1258");
		System.out.println("회원정보 : " + dao.login(cs2).toString());
		
		//
	}

}
