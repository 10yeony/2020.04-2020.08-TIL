package inheritance.test;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;
import inheritance.service.EmployeeService;
import inheritance.util.MyDate;

public class PolymorphismTest3 {
	public static void main(String[] args) {
		///////////////////////////////////////////////////////////////////
		// �̰� �ٷ� Polymorphism
		System.out.println("=========== Polymorphism ������� ��ü ���� ===========");
		Employee e2 = new Manager("��ȣ��2", 23000.0, new MyDate(1972, 11, 1), "ü����");
		Employee e3 = new Engineer("�ڳ���2", 56000.0, new MyDate(1987, 3, 1), "R", 200.0);
		Employee e4 = new Secretary("�ں���2", 34000.0, new MyDate(1990, 3, 1), "��ȣ��");
		Employee e5 = new Manager("��ȣ��3", 34000.0, new MyDate(1990, 3, 1), "ü����");
		
		// Haterogeneous Collection
		Employee[ ] emps = {e2,e3,e4,e5};
		
		EmployeeService service = new EmployeeService();
		System.out.println(service.findEmployeeByName(emps, "��ȣ��2").getDetails());
		//getDetails() ���� ����ϸ� �ּҰ��� ��µ�.
	}
}
