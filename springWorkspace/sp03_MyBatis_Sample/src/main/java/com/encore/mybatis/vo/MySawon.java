package com.encore.mybatis.vo;
/*
 * Framework에서는 반드시 기본 생성자를 넣어야 한다.(생성자 아무것도 안 넣었을 경우에는 알아서 만들어짐)
 * MyBatis에서는 값의 주입을 Setter로 하고, 받아올 때는 Getter로 받아옴
 */
public class MySawon {
	private int num, age; //num은 auto_increment
	private String id, pwd, name, hiredate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	@Override
	public String toString() {
		return "MySawon [num=" + num + ", age=" + age + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", hiredate="
				+ hiredate + "]";
	}
}
