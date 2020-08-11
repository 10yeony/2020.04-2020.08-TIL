package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

// �ڽ�, Child, Sub Ŭ����
public class Manager extends Employee{ 
	private String dept; 
	
	public Manager(String dept) {
		super(); 
		this.dept = dept;
	}
	
	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate); 
		this.dept = dept;
	}
	
	public void changeDept(String dept) {
		this.dept = dept;
	}

	//��ӿ����� method... 1. �״�� �����޴´� 2. ������ �°� ��ģ��.
	//�������̵��� �޼ҵ�
	public String getDetails() {
		return super.getDetails() + ", " +dept; 
		// Employee�� getDetail() ȣ��
		
	}
}
