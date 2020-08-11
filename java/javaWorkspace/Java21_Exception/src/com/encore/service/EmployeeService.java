package com.encore.service;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import com.encore.exception.DuplicateNameException;
import com.encore.exception.RecordNotFoundException;
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
	
	public void addEmployee(Employee e) throws DuplicateNameException {//DuplicateNameException
		boolean find = false;
		for(Employee emp : list) {
			if(e.getName().equals(emp.getName())) {//�̹� �׷� ����� �ִٸ�...
				find = true;
				throw new DuplicateFormatFlagsException(e.getName()+"���� �̹� ȸ���̽ʴϴ�.");
			}
		}
		if(find==false) { //�߰��ϰ��� �ϴ� ����� ������ ����Ʈ���� ����...
			list.add(e);
			System.out.println(e.getName()+" ���� ȸ������ ��ϵǼ̽��ϴ�.");
		}
	}
	public void deleteEmployee(String name) throws RecordNotFoundException {//RecordNotFoundException
		boolean find = false;
		for(Employee e : list) {
			if(e.getName().equals(name)) {
				find = true;
				list.remove(e);
				System.out.println(name+" ���� �����մϴ�.");
				break;
			}
		}
		if(find == false) 
			throw new RecordNotFoundException("������ ��� ����...");
	}
	public void updateEmployee(Employee e) {//RecordNotFoundException	
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







