package inheritance.parent;

import inheritance.util.MyDate;

// �θ�, Parent, Super Ŭ����...
public class Employee {
	public static final double BASE_SALARY = 100.0; 
	//�����. static final�̶�� �� ������ �ٿ��� ��.
	// �� Ŭ�������� �������� ���̹Ƿ� public�� ����.
	private String name;
	private double salary;
	private MyDate birthDate;
	//�ʵ带 ���������� ������ ���(������,setter)�� ����
	
	// ������ 2��. �⺻ ������ 1�� + ����� ������ 1��
	
	public Employee() {} // �⺻ ������
	// ��ü ���� ������ �����ڰ� ȣ���. 
	// �����ڿ��� ������ ����? -> �ڽ� ��ü ������ �� ������ ���� ��.
	// �ڽ��� ����������� �޸𸮻� �θ� ���� �ö󰡾� ��.
	// �ڽ� ��ü�� �����Ƿ��� ������ �θ� ������ ȣ���� �Ͼ�� ��.
	// �θ��� �⺻ �����ڰ� �־�� ��.
	// �⺻ �����ڷ� ������ٴ� �� ���⿡ ���� ���� �ʾҴ�.
	
	public Employee(String name, double salary, MyDate birthDate) { // ����� ������
		super(); // Employee ���� �θ� ������ �θ�� Object.
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	} // �̸�, ����, �������. �⺻������ ����� ��.
	
	public Employee(String name) { 
		this(name, BASE_SALARY, new MyDate(1980,1,1)); // ������ ���� this
	} // �̸��� �Է����� ��� ����, ��������� �⺻������ ������.
	
	// �����ڴ� ����� �ƴ�.
	
	public String getDetails() {// ���⼭ getDetails ���� toString() ���� ��.
		return name+","+salary+","+birthDate;
	}
}

/*
this
1) ������ �տ� ���̴� this
   ���ú����� �ʵ��� �̸��� ���� �� ���� �����ϱ� ���ؼ� �ʵ� �տ� ���δ�.
2) ������ �տ� ���̴� this
  �ϳ��� Ŭ�������� ���� �ٸ� �����ڸ� ȣ���� �� ����
 */