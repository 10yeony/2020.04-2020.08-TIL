package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

// 자식, Child, Sub 클래스
public class Manager extends Employee{ 
	private String dept; 
	
	public Manager(String dept) {
		super(); 
		this.dept = dept;
	}
	
	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate); 
		this.dept = dept;
	}
	
	public void changeDept(String dept) {
		this.dept = dept;
	}

	//상속에서의 method... 1. 그대로 물려받는다 2. 나에게 맞게 고친다.
	//오버라이딩된 메소드
	public String getDetails() {
		return super.getDetails() + ", " +dept; 
		// Employee의 getDetail() 호출
		
	}
}
