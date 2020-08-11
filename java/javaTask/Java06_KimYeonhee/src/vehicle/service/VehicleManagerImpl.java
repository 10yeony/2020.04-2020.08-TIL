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
	
	// ��ü ���� ����� ��ȯ��
	public Vehicle[] getList() {
		return vList;
	}
	
	// ���������� �߰���
	public void add(Vehicle vehi){
		vList[amount++] = vehi;
	}
	
	// ������� �������� �̸��� ������ ���� ����� ��ȯ��
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
	
	// ������ ������ȣ�� �Է��ϸ� �������� Ÿ�� �ִ� VIP�� ��ȣ���� ��ȯ��
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
		return "�� ������������ "+guard+"(����)���� "+vip+"(VIP)���� ��ȣ�մϴ�.";
	}
	
	// �����縦 �Է��ϸ� ���� ������ ��ȯ��
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
	
	// �ְ� ������ ������ ��ȯ��
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
	
	// ������ȣ�� ������ �Է��ϸ� �ش� ������ȣ�� ã�� ������ �����ϰ� ������ ������ ��ȯ��
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
	
	// ������ȣ�� �Է��ϸ� �ش� ���������� �����ǰ� ��ü ���� ����� ��ȯ��
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
	
	// ��ü ������ ���� ������ ��ȯ��
	public int getTotalPrice(){
		int total = 0;
		for(Vehicle v : vList) {
			if(v == null) continue;
			total += v.getPrice();
		}
		return total;
	}
	
}
