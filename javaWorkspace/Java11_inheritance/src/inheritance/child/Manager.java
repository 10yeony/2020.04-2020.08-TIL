package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

// 자식, Child, Sub 클래스
public class Manager extends Employee{ 
	// 부모로부터 물려받아 확장되었으므로 extends라는 키워드를 씀.
	// 부모로부터 물려받으므로 자기 자신만의 필드를 추가하면 됨.
	private String dept; 
	
	public Manager(String dept) {
		super(); // 내가 호출해주든 안 해주든 부모가 호출됨.
		// 근데 Employee에 갔더니 기본 생성자가 없으면 에러가 남.
		this.dept = dept;
	}
	
	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate); 
		this.dept = dept;
	}
	
	//상속에서의 method... 1. 그대로 물려받는다 2. 나에게 맞게 고친다.
	public String getDetails() {
		return super.getDetails() + ", " +dept; 
		//super.getDetails => Employee의 getDetail() 호출
		// 그냥 getDetails하면 안됨. 자식이 직접 가져와서 쓸 수 없음. 부모에게 접근해서 가져와야 함. 
		// Employee 말고 여기에서의 필드인 dept를 함께 추가해야 함.
		
	}
	// Employee 필드 3개 메소드 1개 => 식구 4명
	// Manager 필드 1개 메소드 1개 추가해서 => 식구 총 6명
}
