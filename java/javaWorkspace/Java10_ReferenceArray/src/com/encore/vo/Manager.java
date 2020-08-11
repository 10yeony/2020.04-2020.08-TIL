package com.encore.vo;

import com.encore.util.MyDate;

public class Manager {
	private String name;
	private MyDate birthDate;
	private double salary;
	private String dept;
	private int deptno;
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.dept = dept;
		this.deptno = deptno;
	}	
	public String getName() {
		return name;
	}
	// name은 유니크한 값이므로 setter 만들지 X
	
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public double getSalary() {
		return salary;
	}
	public String getDept() {
		return dept;
	}
	public int getDeptno() {
		return deptno;
	}
	public String getDetails() {
		return name+","+birthDate+","+salary+","+dept+","+deptno;
	} 
	// birthDate는 참조변수. birthDate.toString()이 생략되어 있어서
	// birthDate에 있는(.) toString()을 쓰겠다.
	// MyDate에 toString이 없는데 돌아감. 있다는 소리.
	// root class가 Object이므로 Object로부터 물려받음. 
	// 코드에 반복적으로 안 써도 자동으로 물려받음.
	
	// birthDate만 하면 주소값이 출력됨.
	// 생년월일로 출력하려면 birthDate.getDate()로 해야 함.
}






