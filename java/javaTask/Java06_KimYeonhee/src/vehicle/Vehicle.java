package vehicle;

public class Vehicle {
	private int num;
	private String model;
	private int price;
	public Vehicle() {}
	public Vehicle(int num, String model, int price) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return num +", "+model+", "+price;
	}
}
