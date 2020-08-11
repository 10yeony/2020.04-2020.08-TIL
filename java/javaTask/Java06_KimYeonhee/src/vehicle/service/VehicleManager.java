package vehicle.service;

import vehicle.Vehicle;

public interface VehicleManager {
	Vehicle[] getList();
	void add(Vehicle vehi);
	int searchInfo(String name);
	String searchInfo(int carNum);
	Vehicle[] searchCarInfo(String maker);
	Vehicle highestPrice();
	Vehicle update(int carNum, int price);
	Vehicle[] delete(int carNum);
	int getTotalPrice();
}
