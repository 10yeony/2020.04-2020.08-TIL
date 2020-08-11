package vehicle.child;

import vehicle.Vehicle;

public class Truck extends Vehicle {
	private int licence; // 면허 종류
	private String company; // 대여 회사명
	public Truck(int num, String model, int price, int licence, String company) {
		super(num, model, price);
		this.licence = licence;
		this.company = company;
	}
	public int isLicence1st() {
		return licence;
	}
	public void setLicence1st(int licence) {
		this.licence = licence;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String toString() {
		return super.toString()+", "+licence+", "+company;
	}
}
