package inheritance.service;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;

//기능만을 모아놓은 서비스 클래스....
public class PolymorphismService {
	//step2
	
	/*
	// Polymorphism 안 쓰면 이걸 각각 핸들링해야 함. 현업 가면 이런 vo가 수십개 넘게 있음. 
	// 상속을 안 쓴 최악의 코드. 절차적 프로그래밍에서는 이렇게 함.
	public void handleManager(Manager m) {}
	public void handleEngineer(Engineer m) {}
	public void handleSecretary(Secretary m) {}
	*/
	
	/* 상속을 안 했어도 이렇게 이름 정하면 안 됨. 어차피 메소드 기능 같음.
	public void handleManager(Manager m) {}
	public void manageEngineer(Engineer m) {}
	public void getSecretary(Secretary m) {}
	*/
	
	//step2
	/* 상속을 안 하더라도 메소드 오버로딩 해야 함.
	public void handleEmployee(Manager m) {}
	public void handleEmployee(Engineer m) {}
	public void handleEmployee(Secretary m) {}
	*/
	
	//step3
	public void handleEmployee(Employee[ ] earr) {
		//1. 만약에 earr에 들어있는 직원이 강호동이라면... 강호동의 부서를 총무부로 바꾸고... 정보 출력
		for(Employee e : earr) {
			// 여러 객체가 한번에 들어있는 배열의 경우 이 객체가 어떤 타입인지 알아야 하는데 그 때 쓸 수 있는 것.
			
			// instanceof 한 것을 각각 객체만 가지고 있는 멤버.. 자기 자신만 가지고 있는 경우
			if(e instanceof Manager) {//e라는 객체가 Manager라면
				if(e.getName().equals("강호동2")) {
					((Manager) e).changeDept("총무부");
				}
			}
			if(e instanceof Engineer) {//e라는 객체가 Engineer라면
				
			}
			if(e instanceof Secretary) {//e라는 객체가 Secretary라면
				
			}
		}
	}
}
