package com.encore.service;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import com.encore.exception.DuplicateNameException;
import com.encore.exception.RecordNotFoundException;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;
// Manager[ ]을 ArrayList<Employee> 사용
public class EmployeeService {
	
	private ArrayList<Employee> list; // ArrayList 선언
	
	// 싱글톤
	private static EmployeeService service = new EmployeeService();
	private EmployeeService(){
		list = new ArrayList<>(); // size 적을 필요 없음
	}
	public static EmployeeService getInstance() {
		return service;
	}
	
	public void addEmployee(Employee e) throws DuplicateNameException {//DuplicateNameException
		boolean find = false;
		for(Employee emp : list) {
			if(e.getName().equals(emp.getName())) {//이미 그런 사람이 있다면...
				find = true;
				throw new DuplicateFormatFlagsException(e.getName()+"님은 이미 회원이십니다.");
			}
		}
		if(find==false) { //추가하고자 하는 사람은 기존의 리스트에는 없다...
			list.add(e);
			System.out.println(e.getName()+" 님이 회원으로 등록되셨습니다.");
		}
	}
	public void deleteEmployee(String name) throws RecordNotFoundException {//RecordNotFoundException
		boolean find = false;
		for(Employee e : list) {
			if(e.getName().equals(name)) {
				find = true;
				list.remove(e);
				System.out.println(name+" 님을 삭제합니다.");
				break;
			}
		}
		if(find == false) 
			throw new RecordNotFoundException("삭제할 대상 없음...");
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
	//추가
	public void getEmployee() {
		for(Employee e : list) System.out.println(e);
	}
}







