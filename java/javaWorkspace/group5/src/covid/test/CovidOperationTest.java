package covid.test;

import java.util.ArrayList;
import java.util.Scanner;

import covid.service.CovidOperationImpl;
import covid.util.Fever;
import covid.vo.child.Staff;
import covid.vo.child.Student;
import covid.vo.child.Teacher;
import covid.vo.parent.Visitor;

public class CovidOperationTest {
	public static void main(String[] args) {
		CovidOperationImpl service = new CovidOperationImpl();
		/*System.out.println("============추가=============");
		
		System.out.println("============삭제=============");
		service.deleteVistor("강호동");
		service.deleteVistor("강호동");
		System.out.println(service.getAllVisitors());
		System.out.println("============이름 입력하고 마스크 착용 확인=============");
		System.out.println(service.checkMask("김연희"));
		System.out.println("============이름 입력하고 증상 업데이트=============");
		System.out.println(service.updateCondition("김연희", "두통"));
		System.out.println("============이름 입력하고 체온 업데이트=============");
		System.out.println(service.updateCondition("하승현", new Fever(36.4, 35.9)));*/
		
		
		Scanner sc = new Scanner(System.in);
		
		aaa : while(true)
		{
			String menu = "";
			menu += "번호를 선택하세요\n";
			menu += "1:방문회원 추가\n";
			menu += "2:전체회원 조회\n";
			menu += "3:방문회원 삭제\n";
			menu += "4:마스크 착용 여부 조회\n";
			menu += "5:특정 온도 이상 발열 회원 조회\n";
			menu += "6:체온 업데이트\n";
			menu += "7: 증상 업데이트\n";
			menu += "0:끝내기";

			System.out.println(menu);
			int number = sc.nextInt();
			
			switch(number)
			{
			case 0: 
				break aaa;
			case 1:
				service.addVisitor(new Visitor("김연희", false, new Fever(35.9, 37.8)));
				service.addVisitor(new Visitor("전정용", true, new Fever(35.9, 36.5), "기침"));
				service.addVisitor(new Student("오세훈", true, new Fever(37.9, 36.5), "오한", 4, "기계공학과"));
				service.addVisitor(new Staff("강호동", false, new Fever(36.9, 36.5), 2000000, "시설관리부"));
				service.addVisitor(new Teacher("하승현", true, new Fever(36.5, 36.5), 30, "프리랜서"));
				service.addVisitor(new Teacher("하승현", false, new Fever(36.5, 36.5), 30, "프리랜서"));
				
				System.out.println("번호 선택 (1:Visitor / 2:Student / 3:Staff / 4:Teacher) : ");
				int num = sc.nextInt(); 
				
				if(num < 0 || 2 < num)
					continue;
				String symptom = null;
				System.out.println("이름을 입력하세요 : ");
				String name = sc.next();
				System.out.println("마스크 착용 여부를 입력하세요 : True / False");
				boolean mask = sc.nextBoolean();
				System.out.println("오전에 측정한 체온을 입력하세요.");
				double temperature1 = sc.nextDouble();
				System.out.println("오후에 측정한 체온을 입력하세요.");
				double temperature2 = sc.nextDouble();
				System.out.println("현재 특별한 증상이 있습니까? : 네 / 아니오");
				String answer = sc.next();
				if(answer.equals("네")) {
					System.out.println("증상을 입력해주세요. : ");
					symptom = sc.next();
				}
				else continue;
				
				if(num==1){
					if(answer.equals("아니오")) {
						service.addVisitor(new Visitor(name, mask, new Fever(temperature1, temperature2)));
					}
					else if(answer.equals("네")) {
						service.addVisitor(new Visitor(name, mask, new Fever(temperature1, temperature2), symptom));
					}
				}
				else if(num == 2){
					System.out.println("강의실 번호를 입력하세요");
					int roomNum = sc.nextInt();
					System.out.println("전공을 입력하세요.");
					String major = sc.next();
					if(answer.equals("아니오")) {
						service.addVisitor(new Student(name, mask, new Fever(temperature1, temperature2), roomNum, major));
					}
					else if(answer.equals("네")) {
						service.addVisitor(new Student(name, mask, new Fever(temperature1, temperature2), symptom, roomNum, major));
					}
				}
				else if(num == 3) {
					System.out.println("월급을 입력하세요");
					double salary = sc.nextDouble();
					System.out.println("부서를 입력하세요");
					String dept = sc.next();
					if(answer.equals("아니오")) {
						service.addVisitor(new Staff(name, mask, new Fever(temperature1, temperature2), salary, dept));
					}
					else if(answer.equals("네")) {
						service.addVisitor(new Staff(name, mask, new Fever(temperature1, temperature2), symptom, salary, dept));
					}
				}
				else if(num == 4) {
					System.out.println("경력을 입력하세요.");
					int career = sc.nextInt();
					System.out.println("소속을 입력하세요");
					String company = sc.next();
					if(answer.equals("아니오")) {
						service.addVisitor(new Teacher(name, mask, new Fever(temperature1, temperature2), career, company));
					}
					else if(answer.equals("네")) {
						service.addVisitor(new Teacher(name, mask, new Fever(temperature1, temperature2), symptom, career, company));
					}
				}
				break;
				
			case 2:
				System.out.println(service.getAllVisitors());
				break;
				
			case 3:
				System.out.println("삭제할 회원 이름을 입력하세요.");
				String name1 = sc.next();
				service.deleteVistor(name1);
				break;
				
			case 4:
				System.out.println("마스크 착용 여부를 조회할 회원 이름을 입력하세요.");
				String name2 = sc.next();
				System.out.println(service.checkMask(name2));				
				break;
				
			case 5:
				System.out.println("조회할 체온을 입력하세요.");
				double temperature3 = sc.nextDouble();
				System.out.println(service.overTemperature(temperature3));
				break;
				
			case 6:
				System.out.println("회원 이름을 입력하세요.");
				String name3 = sc.next();
				System.out.println("오전에 측정한 체온을 입력하세요.");
				double temperature4 = sc.nextDouble();
				System.out.println("오후에 측정한 체온을 입력하세요.");
				double temperature5 = sc.nextDouble();
				System.out.println(service.updateCondition(name3, new Fever(temperature4, temperature5)));
				break;
			case 7:
				System.out.println("회원 이름을 입력하세요.");
				String name4 = sc.next();
				System.out.println("증상을 입력하세요.");
				String symptom2 = sc.next();
				System.out.println(service.updateCondition(name4, symptom2));
				break;
			}
		}	
	}
}
