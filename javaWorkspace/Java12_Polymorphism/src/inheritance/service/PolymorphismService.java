package inheritance.service;

import inheritance.child.Engineer;
import inheritance.child.Manager;
import inheritance.child.Secretary;
import inheritance.parent.Employee;

//��ɸ��� ��Ƴ��� ���� Ŭ����....
public class PolymorphismService {
	//step2
	
	/*
	// Polymorphism �� ���� �̰� ���� �ڵ鸵�ؾ� ��. ���� ���� �̷� vo�� ���ʰ� �Ѱ� ����. 
	// ����� �� �� �־��� �ڵ�. ������ ���α׷��ֿ����� �̷��� ��.
	public void handleManager(Manager m) {}
	public void handleEngineer(Engineer m) {}
	public void handleSecretary(Secretary m) {}
	*/
	
	/* ����� �� �߾ �̷��� �̸� ���ϸ� �� ��. ������ �޼ҵ� ��� ����.
	public void handleManager(Manager m) {}
	public void manageEngineer(Engineer m) {}
	public void getSecretary(Secretary m) {}
	*/
	
	//step2
	/* ����� �� �ϴ��� �޼ҵ� �����ε� �ؾ� ��.
	public void handleEmployee(Manager m) {}
	public void handleEmployee(Engineer m) {}
	public void handleEmployee(Secretary m) {}
	*/
	
	//step3
	public void handleEmployee(Employee[ ] earr) {
		//1. ���࿡ earr�� ����ִ� ������ ��ȣ���̶��... ��ȣ���� �μ��� �ѹ��η� �ٲٰ�... ���� ���
		for(Employee e : earr) {
			// ���� ��ü�� �ѹ��� ����ִ� �迭�� ��� �� ��ü�� � Ÿ������ �˾ƾ� �ϴµ� �� �� �� �� �ִ� ��.
			
			// instanceof �� ���� ���� ��ü�� ������ �ִ� ���.. �ڱ� �ڽŸ� ������ �ִ� ���
			if(e instanceof Manager) {//e��� ��ü�� Manager���
				if(e.getName().equals("��ȣ��2")) {
					((Manager) e).changeDept("�ѹ���");
				}
			}
			if(e instanceof Engineer) {//e��� ��ü�� Engineer���
				
			}
			if(e instanceof Secretary) {//e��� ��ü�� Secretary���
				
			}
		}
	}
}
