package io.object.test;

import java.io.Serializable;

/*
 * 직렬화
 * ObjectOutputStream... Sink쪽으로 객체가 날아간다.
 * 정확히 표현하면 객체의 필드값이 직렬화되어져서 객체 스트림을 통과하는 것.
 * 
 * 이렇게 Person이 객체 스트림을 직렬화로 통과하려면.....
 * 반드시 Serializable 인터페이스를 implements 해야 한다.
 */
public class Person implements Serializable {
	// 원래 인터페이스 그냥 만들면 빨간 줄 떠야 하는데 안 뜸.
	// 왜냐하면 이건 그냥 마킹하는 인터페이스. 얘를 implements한 객체는 직렬화를 보장받는다.
	
	private String name;
	private int age;
	private String password;
	public Person(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}
	public Person() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", password=" + password + "]";
	}
}
