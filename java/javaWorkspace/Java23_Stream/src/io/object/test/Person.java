package io.object.test;

import java.io.Serializable;

/*
 * ����ȭ
 * ObjectOutputStream... Sink������ ��ü�� ���ư���.
 * ��Ȯ�� ǥ���ϸ� ��ü�� �ʵ尪�� ����ȭ�Ǿ����� ��ü ��Ʈ���� ����ϴ� ��.
 * 
 * �̷��� Person�� ��ü ��Ʈ���� ����ȭ�� ����Ϸ���.....
 * �ݵ�� Serializable �������̽��� implements �ؾ� �Ѵ�.
 */
public class Person implements Serializable {
	// ���� �������̽� �׳� ����� ���� �� ���� �ϴµ� �� ��.
	// �ֳ��ϸ� �̰� �׳� ��ŷ�ϴ� �������̽�. �긦 implements�� ��ü�� ����ȭ�� ����޴´�.
	
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
