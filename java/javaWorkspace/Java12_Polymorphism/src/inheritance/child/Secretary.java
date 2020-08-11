package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

// 자식, Child, Sub 클래스
public class Secretary extends Employee{ 
	private String nameOfBoss; 
	
	public Secretary(String dept) {
		super();
		this.nameOfBoss = nameOfBoss;
	}
	
	public Secretary(String name, double salary, MyDate birthDate, String nameOfBoss) {
		super(name, salary, birthDate); 
		this.nameOfBoss = nameOfBoss;
	}
	
	//상속에서의 method... 1. 그대로 물려받는다 2. 나에게 맞게 고친다.
	//오버라이딩된 메소드
	public String getDetails() {
		return super.getDetails() + ", " +nameOfBoss; 
		//Employee의 getDetail() 호출
		
	}
}
