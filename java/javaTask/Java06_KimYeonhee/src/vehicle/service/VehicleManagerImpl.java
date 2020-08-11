package vehicle.service;

import vehicle.Vehicle;
import vehicle.child.Limousine;
import vehicle.child.Motocycle;

public class VehicleManagerImpl implements VehicleManager {
	private Vehicle[] vList = new Vehicle[100];
	private int amount;
	private static VehicleManagerImpl vihiMgr = new VehicleManagerImpl();
	private VehicleManagerImpl() {}
	public static VehicleManagerImpl getInstance() {
		return vihiMgr;
	}
	
	// 전체 차량 목록을 반환함
	public Vehicle[] getList() {
		return vList;
	}
	
	// 차량정보를 추가함
	public void add(Vehicle vehi){
		vList[amount++] = vehi;
	}
	
	// 오토바이 운전자의 이름을 넣으면 운전 경력을 반환함
	public int searchInfo(String name){
		int year = 0;
		for(Vehicle v : vList) {
			if(v == null) continue;
			if(v instanceof Motocycle) {
				if(((Motocycle) v).getName() == name) {
					year = ((Motocycle) v).getCareer();
				}
 			}
		}
		return year;
	}
	
	// 리무진 차량번호를 입력하면 리무진에 타고 있는 VIP와 경호원을 반환함
	public String searchInfo(int carNum){
		String vip = null;
		String guard = null;
		for(Vehicle v : vList) {
			if(v == null) continue;
			if(v instanceof Limousine) {
				if(v.getNum() == carNum) {
					vip = ((Limousine) v).getVipName();
					guard = ((Limousine) v).getGuard();
				}
			}
		}
		return "이 리무진에서는 "+guard+"(가드)님이 "+vip+"(VIP)님을 경호합니다.";
	}
	
	// 제조사를 입력하면 차량 정보를 반환함
	public Vehicle[] searchCarInfo(String maker){
		int index = 0;
		Vehicle[] temp = new Vehicle[amount];
		for(Vehicle v : vList) {
			if(v == null) continue;
			if(v.getModel().equals(maker)) {
				temp[index++] = v;
			}
		}
		Vehicle[] temp2 = new Vehicle[index];
		if(index > 0) {
			System.arraycopy(temp, 0, temp2, 0, index);
		}
		return temp2;
	}
	
	// 최고가 차량의 정보를 반환함
	public Vehicle highestPrice(){
		int max = vList[0].getPrice();
		int index = 0;
		for(int i = 0; i < amount; i++) {
			if(vList[i] == null) continue;
			if(max < vList[i].getPrice()) {
				max = vList[i].getPrice();
				index = i;
			}
		}
		return vList[index];
	}
	
	// 차량번호와 가격을 입력하면 해당 차량번호를 찾아 가격을 수정하고 수정된 정보를 반환함
	public Vehicle update(int carNum, int price){
		Vehicle temp = null;
		for(Vehicle v : vList) {
			if(v == null) continue;
			if(v.getNum() == carNum) {
				v.setPrice(price);
				temp = v;
			}
		}
		return temp;
	}
	
	// 차량번호를 입력하면 해당 차량정보가 삭제되고 전체 차량 목록을 반환함
	public Vehicle[] delete(int carNum){
		for(int i = 0; i < amount; i++) {
			if(vList[i] == null) continue;
			if(vList[i].getNum() == carNum) {
				for(int j = i; j < amount; j++) {
					vList[j] = vList[j+1];
				}
			}
		}
		Vehicle[] temp = new Vehicle[amount-1];
		for(int i = 0; i < amount-1; i++) {
			temp[i] = vList[i];
		}
		return temp;
	}
	
	// 전체 차량의 가격 총합을 반환함
	public int getTotalPrice(){
		int total = 0;
		for(Vehicle v : vList) {
			if(v == null) continue;
			total += v.getPrice();
		}
		return total;
	}
	
}
