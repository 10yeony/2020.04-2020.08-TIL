package com.encore.vo;

import com.encore.util.MyDate;

public class Manager extends Employee {
	private String dept;
	private int deptno;
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		super(name, birthDate, salary);
		this.dept = dept;
		this.deptno = deptno;
	}	
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDept() {
		return dept;
	}
	public int getDeptno() {
		return deptno;
	}
	@Override
	public String toString() {
		return super.toString()+" "+dept+" "+deptno;
	}
	// birthDate는 참조변수. birthDate.toString()이 생략되어 있어서
	// birthDate에 있는(.) toString()을 쓰겠다.
	// MyDate에 toString이 없는데 돌아감. 있다는 소리.
	// root class가 Object이므로 Object로부터 물려받음. 
	// 코드에 반복적으로 안 써도 자동으로 물려받음.
	
	// birthDate만 하면 주소값이 출력됨.
	// 생년월일로 출력하려면 birthDate.getDate()로 해야 함.
}






