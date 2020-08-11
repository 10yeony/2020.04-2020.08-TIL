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
		vehiMgr.add(new Truck(16, "벤츠", 90000, 1, "화물운송연합"));
		// int num, String model, int price, int licence, String company
		vehiMgr.add(new Limousine(24, "아우디", 110000, "김혜수", "이희진"));
		// int num, String model, int price, String vipName, String guard
		vehiMgr.add(new Motocycle(55, "BMW", 70000, "송은이", 10));
		vehiMgr.add(new Motocycle(79, "KR모터스", 50000, "박나래", 6));
		// int num, String model, int price, int career
		
		System.out.println("===== 차량정보를 추가함 =====");
		vehiMgr.add(new Vehicle(60, "현대", 100000));
		for(Vehicle v : vehiMgr.getList()) {
			if(v == null) continue;
			System.out.println(v);
		}
		System.out.println("===== 오토바이 운전자의 이름을 넣으면 운전 경력을 반환함 =====");
		System.out.println("오토바이 총 경력 : "+vehiMgr.searchInfo("송은이")+"년");
		System.out.println("===== 리무진 차량번호를 입력하면 리무진에 타고 있는 VIP와 경호원을 반환함 =====");
		System.out.println(vehiMgr.searchInfo(24));
		System.out.println("===== 제조사를 입력하면 차량 정보를 반환함 =====");
		System.out.println(Arrays.toString(vehiMgr.searchCarInfo("BMW")));
		System.out.println("===== 최고가 차량의 정보를 반환함 =====");
		System.out.println(vehiMgr.highestPrice());
		System.out.println("===== 차량번호와 가격을 입력하면 해당 차량번호를 찾아 가격을 수정하고 수정된 정보를 반환함 =====");
		System.out.println(vehiMgr.update(79, 30000));
		System.out.println("===== 차량번호를 입력하면 해당 차량정보가 삭제되고 전체 차량 목록을 반환함 =====");
		System.out.println(Arrays.toString(vehiMgr.delete(16)));
		System.out.println("===== 전체 차량의 가격 총합을 반환함 ====="); 
		System.out.println("합계 : "+vehiMgr.getTotalPrice()+"원");

	}
}
