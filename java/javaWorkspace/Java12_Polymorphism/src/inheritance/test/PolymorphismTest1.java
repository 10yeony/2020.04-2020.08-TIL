package inheritance.test;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;
import inheritance.util.MyDate;

/*
 * 폴리몰피즘(다형성)
 * ::
 * poly + morphism
 * ::
 * 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
 * ::
 * 부모타입으로 자식객체 생성하는 것
 * 
 * Virtual Methods(이 때 가상 메소드는 자식의 메소드) Invocation 원리
 * : 상속 + 오버라이딩된 메소드에서만 나타나는 성질
 * 1) 컴파일 시점 메소드 : 컴파일 시점에서는 부모타입 메소드를 호출. Employee의 getDetails()를 호출
 * 2) 실행 시점 메소드 : 실행 시점에서는 자식의 메소드가 호출. 자식의 getDetails()를 호출.
 * 
 * Object Casting
 */
public class PolymorphismTest1 {
	public static void main(String[] args) {
		Employee e1 = new Employee("이수근", 12000.0, new MyDate(1975, 1, 1));
		Manager m1 = new Manager("강호동", 23000.0, new MyDate(1972, 11, 1), "체육부");
		Engineer eg1 = new Engineer("박나래", 56000.0, new MyDate(1987, 3, 1), "R", 200.0);
		Secretary s1 = new Secretary("박보검", 34000.0, new MyDate(1990, 3, 1), "강호동");
		
		m1.changeDept("기획부");
		System.out.println("=========== 정보를 출력합니다. ===========");
		System.out.println(e1.getDetails());
		System.out.println(m1.getDetails());
		System.out.println(eg1.getDetails());
		System.out.println(s1.getDetails());
		
		///////////////////////////////////////////////////////////////////
		// 이게 바로 Polymorphism
		System.out.println("=========== Polymorphism 방식으로 객체 생성 ===========");
		Employee e2 = new Manager("강호동2", 23000.0, new MyDate(1972, 11, 1), "체육부");
		Employee e3 = new Engineer("박나래2", 56000.0, new MyDate(1987, 3, 1), "R", 200.0);
		Employee e4 = new Secretary("박보검2", 34000.0, new MyDate(1990, 3, 1), "강호동");
		
		//추가
		// e3.changeTech("자바") 
		// Employee에 있는 changeTech()를 호출해라! 그런데 Engineer에만 있으므로 찾을 수 없음.
		// 자식만의 멤버를 호출하거나 변경하려고 할 수 없음.
		
		/*//Object Casting
		Engineer eg3 = (Engineer)e3; //e3를 Engineer 타입으로 캐스팅
		eg3.changeTech("Java");
		// 내가 찾고자 하는 클래스 타입으로 찾는 것이 casting
		*/
		
		// 부모 타입으로 자식 객체를 만들었을 때(Polymorphism 방식으로 객체를 만들었을 때)
		// 자식 만의 멤버를 만들려고 하면 캐스팅해서 써야 함.
		((Engineer) e3).changeTech("자바");
		
		System.out.println("=========== 정보를 출력합니다2 ===========");
		System.out.println(e2.getDetails()); 
		System.out.println(e3.getDetails());
		System.out.println(e4.getDetails());
		// 원래는 출력하면 birthDate까지만 나와야 함.
		// 하지만 상속받고 오버라이딩 했으므로 전부 다 나옴.
	}

}
