package broker.twotier.vo;

import java.util.Vector;

public class CustomerRec {
	private String ssn;
	private String name; // 컬럼명은 cust_name
	private String address;
	private Vector<SharesRec> portfolio;
	
	public CustomerRec(String ssn, String name, String address, Vector<SharesRec> portfolio) {
		// 현업에서 개발자들이 Vector를 설계할 생각을 못함. 해징 관계를 생각 안함.
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.portfolio = portfolio;
	}
	public CustomerRec(String ssn, String name, String address) {
		this(ssn, name, address, null);
	}

	public CustomerRec() {
		super();
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Vector<SharesRec> getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Vector<SharesRec> portfolio) {
		this.portfolio = portfolio;
	}
	@Override
	public String toString() {
		return "Customer [ssn=" + ssn + ", name=" + name + ", address=" + address + ", portfolio=" + portfolio + "]";
	}
	
}
