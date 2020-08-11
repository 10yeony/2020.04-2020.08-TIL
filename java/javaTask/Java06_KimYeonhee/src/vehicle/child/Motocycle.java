package vehicle.child;

import vehicle.Vehicle;

public class Motocycle extends Vehicle {
	private String name; // ������ �̸�
	private int career; // ���� ���
	public Motocycle(int num, String model, int price, String name, int career) {
		super(num, model, price);
		this.name = name;
		this.career = career;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCareer() {
		return career;
	}
	public void setCareer(int career) {
		this.career = career;
	}
	public String toString() {
		return super.toString()+", "+name+", "+career;
	}
}
