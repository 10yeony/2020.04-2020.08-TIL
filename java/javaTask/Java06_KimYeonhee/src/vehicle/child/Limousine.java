package vehicle.child;

import vehicle.Vehicle;

public class Limousine extends Vehicle {
	private String vipName; // vip 고객 이름
	private String guard; // 경호원 이름
	public Limousine(int num, String model, int price, String vipName, String guard) {
		super(num, model, price);
		this.vipName = vipName;
		this.guard = guard;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public String getGuard() {
		return guard;
	}
	public void setGuard(String guard) {
		this.guard = guard;
	}
	public String toString() {
		return super.toString()+", "+vipName+", "+guard;
	}
}
