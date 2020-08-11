package inheritance.child;

import inheritance.parent.Employee;
import inheritance.util.MyDate;

// �ڽ�, Child, Sub Ŭ����
public class Manager extends Employee{ 
	// �θ�κ��� �����޾� Ȯ��Ǿ����Ƿ� extends��� Ű���带 ��.
	// �θ�κ��� ���������Ƿ� �ڱ� �ڽŸ��� �ʵ带 �߰��ϸ� ��.
	private String dept; 
	
	public Manager(String dept) {
		super(); // ���� ȣ�����ֵ� �� ���ֵ� �θ� ȣ���.
		// �ٵ� Employee�� ������ �⺻ �����ڰ� ������ ������ ��.
		this.dept = dept;
	}
	
	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate); 
		this.dept = dept;
	}
	
	//��ӿ����� method... 1. �״�� �����޴´� 2. ������ �°� ��ģ��.
	public String getDetails() {
		return super.getDetails() + ", " +dept; 
		//super.getDetails => Employee�� getDetail() ȣ��
		// �׳� getDetails�ϸ� �ȵ�. �ڽ��� ���� �����ͼ� �� �� ����. �θ𿡰� �����ؼ� �����;� ��. 
		// Employee ���� ���⿡���� �ʵ��� dept�� �Բ� �߰��ؾ� ��.
		
	}
	// Employee �ʵ� 3�� �޼ҵ� 1�� => �ı� 4��
	// Manager �ʵ� 1�� �޼ҵ� 1�� �߰��ؼ� => �ı� �� 6��
}
