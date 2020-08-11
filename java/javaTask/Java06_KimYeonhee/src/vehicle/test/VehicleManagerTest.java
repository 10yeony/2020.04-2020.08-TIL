package vehicle.test;

import java.util.Arrays;

import vehicle.Vehicle;
import vehicle.child.Limousine;
import vehicle.child.Motocycle;
import vehicle.child.Truck;
import vehicle.service.VehicleManagerImpl;

public class VehicleManagerTest {
	public static void main(String[] args) {
		VehicleManagerImpl vehiMgr = VehicleManagerImpl.getInstance();

		vehiMgr.add(new Vehicle(23, "BMW", 100000));
		// int num, String model, int price
		vehiMgr.add(new Truck(16, "����", 90000, 1, "ȭ����ۿ���"));
		// int num, String model, int price, int licence, String company
		vehiMgr.add(new Limousine(24, "�ƿ��", 110000, "������", "������"));
		// int num, String model, int price, String vipName, String guard
		vehiMgr.add(new Motocycle(55, "BMW", 70000, "������", 10));
		vehiMgr.add(new Motocycle(79, "KR���ͽ�", 50000, "�ڳ���", 6));
		// int num, String model, int price, int career
		
		System.out.println("===== ���������� �߰��� =====");
		vehiMgr.add(new Vehicle(60, "����", 100000));
		for(Vehicle v : vehiMgr.getList()) {
			if(v == null) continue;
			System.out.println(v);
		}
		System.out.println("===== ������� �������� �̸��� ������ ���� ����� ��ȯ�� =====");
		System.out.println("������� �� ��� : "+vehiMgr.searchInfo("������")+"��");
		System.out.println("===== ������ ������ȣ�� �Է��ϸ� �������� Ÿ�� �ִ� VIP�� ��ȣ���� ��ȯ�� =====");
		System.out.println(vehiMgr.searchInfo(24));
		System.out.println("===== �����縦 �Է��ϸ� ���� ������ ��ȯ�� =====");
		System.out.println(Arrays.toString(vehiMgr.searchCarInfo("BMW")));
		System.out.println("===== �ְ� ������ ������ ��ȯ�� =====");
		System.out.println(vehiMgr.highestPrice());
		System.out.println("===== ������ȣ�� ������ �Է��ϸ� �ش� ������ȣ�� ã�� ������ �����ϰ� ������ ������ ��ȯ�� =====");
		System.out.println(vehiMgr.update(79, 30000));
		System.out.println("===== ������ȣ�� �Է��ϸ� �ش� ���������� �����ǰ� ��ü ���� ����� ��ȯ�� =====");
		System.out.println(Arrays.toString(vehiMgr.delete(16)));
		System.out.println("===== ��ü ������ ���� ������ ��ȯ�� ====="); 
		System.out.println("�հ� : "+vehiMgr.getTotalPrice()+"��");

	}
}
