package inheritance.test;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;
import inheritance.service.PolymorphismService;
import inheritance.util.MyDate;

public class PolymorphismTest2 {
	public static void main(String[] args) {
		///////////////////////////////////////////////////////////////////
		// 이게 바로 Polymorphism
		System.out.println("=========== Polymorphism 방식으로 객체 생성 ===========");
		Employee e2 = new Manager("강호동2", 23000.0, new MyDate(1972, 11, 1), "체육부");
		Employee e3 = new Engineer("박나래2", 56000.0, new MyDate(1987, 3, 1), "R", 200.0);
		Employee e4 = new Secretary("박보검2", 34000.0, new MyDate(1990, 3, 1), "강호동");
		Employee e5 = new Manager("강호동3", 34000.0, new MyDate(1990, 3, 1), "체육부");
		// 실질적으로 생성된 객체는 Manager, Engineer, Secretary, Manager가 있고
		// 타입은 Employee.
		
		// 배열은 같은 타입으로만 만들 수 있는데, (물론 Employee로 타입이 같지만) 다른 형태로 배열을 만들 수 있게 됨.
		// 이건 Haterogeneous Collection
		Employee[ ] emps = {e2,e3,e4,e5};
		
		// Homogeneous Collection은 같은 타입으로만 배열을 만듦.
		// 우리는 Haterogeneous Collection을 더 많이 쓰게 될 것.
		
		PolymorphismService service = new PolymorphismService();
		service.handleEmployee(emps);
		
		for(Employee e : emps) {
			System.out.println(e.getDetails());
		}
	}

}
