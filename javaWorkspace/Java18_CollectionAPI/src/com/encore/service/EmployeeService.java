package com.encore.service;
import java.util.ArrayList;

import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;
// Manager[ ]�� ArrayList<Employee> ���
public class EmployeeService {
	
	private ArrayList<Employee> list; // ArrayList ����
	
	// �̱���
	private static EmployeeService service = new EmployeeService();
	private EmployeeService(){
		list = new ArrayList<>(); // size ���� �ʿ� ����
	}
	public static EmployeeService getInstance() {
		return service;
	}
	
	public void addEmployee(Employee e) {	
		boolean find = false;
		for(Employee emp : list) {
			if(e.getName().equals(emp.getName())) {//�̹� �׷� ����� �ִٸ�...
				find = true;
				System.out.println(e.getName()+"���� �̹� ȸ���̽ʴϴ�.");
				return;
			}
		}
		if(find==false) { //�߰��ϰ��� �ϴ� ����� ������ ����Ʈ���� ����...
			list.add(e);
			System.out.println(e.getName()+" ���� ȸ������ ��ϵǼ̽��ϴ�.");
		}
	}
	public void deleteEmployee(String name) {	
		boolean find = false;
		for(Employee e : list) {
			if(e.getName().equals(name)) {
				find = true;
				list.remove(e);
				System.out.println(name+" ���� �����մϴ�.");
				break;
			}
		}
		if(find == false) System.out.println("�������� �ʴ� ȸ���Դϴ�.");
	}
	public void updateEmployee(Employee e) {	
		//
		System.out.println(list);
	}
	public ArrayList<String> findEmployee(double sal) {
		ArrayList<String> temp = new ArrayList<>();
		for(Employee e : list) {
			if(e.getSalary() == sal) temp.add(e.toString());
		}
		return temp;
	}
	//�߰�
	public void getEmployee() {
		for(Employee e : list) System.out.println(e);
	}
}







