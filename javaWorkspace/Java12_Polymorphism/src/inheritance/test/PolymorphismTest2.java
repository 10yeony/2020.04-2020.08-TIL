package inheritance.test;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;
import inheritance.service.PolymorphismService;
import inheritance.util.MyDate;

public class PolymorphismTest2 {
	public static void main(String[] args) {
		///////////////////////////////////////////////////////////////////
		// �̰� �ٷ� Polymorphism
		System.out.println("=========== Polymorphism ������� ��ü ���� ===========");
		Employee e2 = new Manager("��ȣ��2", 23000.0, new MyDate(1972, 11, 1), "ü����");
		Employee e3 = new Engineer("�ڳ���2", 56000.0, new MyDate(1987, 3, 1), "R", 200.0);
		Employee e4 = new Secretary("�ں���2", 34000.0, new MyDate(1990, 3, 1), "��ȣ��");
		Employee e5 = new Manager("��ȣ��3", 34000.0, new MyDate(1990, 3, 1), "ü����");
		// ���������� ������ ��ü�� Manager, Engineer, Secretary, Manager�� �ְ�
		// Ÿ���� Employee.
		
		// �迭�� ���� Ÿ�����θ� ���� �� �ִµ�, (���� Employee�� Ÿ���� ������) �ٸ� ���·� �迭�� ���� �� �ְ� ��.
		// �̰� Haterogeneous Collection
		Employee[ ] emps = {e2,e3,e4,e5};
		
		// Homogeneous Collection�� ���� Ÿ�����θ� �迭�� ����.
		// �츮�� Haterogeneous Collection�� �� ���� ���� �� ��.
		
		PolymorphismService service = new PolymorphismService();
		service.handleEmployee(emps);
		
		for(Employee e : emps) {
			System.out.println(e.getDetails());
		}
	}

}
