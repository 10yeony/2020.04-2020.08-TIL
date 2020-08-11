package inheritance.parent;

import inheritance.util.MyDate;

// 부모, Parent, Super 클래스...
public class Employee {
	public static final double BASE_SALARY = 100.0; 
	//상수값. static final이라는 걸 무조건 붙여야 함.
	// 이 클래스에서 범용적인 값이므로 public을 붙임.
	private String name;
	private double salary;
	private MyDate birthDate;
	//필드를 생성했으면 생성의 통로(생성자,setter)를 생각
	
	// 생성자 2개. 기본 생성자 1개 + 명시적 생성자 1개
	
	public Employee() {} // 기본 생성자
	// 객체 생성 때마다 생성자가 호출됨. 
	// 생성자에서 에러가 난다? -> 자식 객체 생성할 때 문제가 생긴 것.
	// 자식이 만들어지려면 메모리상에 부모가 먼저 올라가야 함.
	// 자식 객체가 생성되려면 무조건 부모 생성자 호출이 일어나야 함.
	// 부모의 기본 생성자가 있어야 함.
	// 기본 생성자로 만들었다는 걸 여기에 값이 들어가지 않았다.
	
	public Employee(String name, double salary, MyDate birthDate) { // 명시적 생성자
		super(); // Employee 위에 부모가 없으면 부모는 Object.
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	} // 이름, 월급, 생년월일. 기본적으로 여기로 감.
	
	public Employee(String name) { 
		this(name, BASE_SALARY, new MyDate(1980,1,1)); // 생성자 앞의 this
	} // 이름만 입력했을 경우 월급, 생년월일은 기본값으로 지정함.
	
	// 생성자는 멤버가 아님.
	
	public String getDetails() {// 여기서 getDetails 말고 toString() 만들어도 됨.
		return name+","+salary+","+birthDate;
	}
}

/*
this
1) 변수명 앞에 붙이는 this
   로컬변수와 필드의 이름이 같을 때 둘을 구분하기 위해서 필드 앞에 붙인다.
2) 생성자 앞에 붙이는 this
  하나의 클래스에서 서로 다른 생성자를 호출할 때 사용됨
 */