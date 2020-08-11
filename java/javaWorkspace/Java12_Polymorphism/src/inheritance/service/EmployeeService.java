package inheritance.service;

import inheritance.child.Engineer;
import inheritance.parent.Employee;

public class EmployeeService {
	public void printInfo(Employee e) {
		System.out.println(e.getDetails());
	}
	
	public void printAllInfo(Employee[] ea) {
		for(Employee e : ea) {
			System.out.println(e.getDetails());
		}
	}
	
	public Employee findEmployeeByName(Employee[] ea, String name) {
		Employee emp = null; // return Ÿ���� void�� �ƴ� ��� �����ϰ� �� ��.
		for(Employee e : ea) {
			if(e.getName().equals(name)) {
				emp = e;
			}
		}
		return emp;
	}	
	
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int)(e.getSalary()*12); //Salary�� double���̶� ���� int������ �ٲ���.
		if(e instanceof Engineer) {
			Engineer eg = (Engineer)e; // getBonus�� Engineer���� �־ ĳ��������� ��.
			annualSalary = (int)(eg.getSalary() * 12 + eg.getBonus());
		}
		return annualSalary;
	}
	
	public int getTotalCost(Employee[] ea) {
		int total = 0;
		for(Employee e : ea) {
			total += getAnnualSalary(e);
		}
		return total;
	}
}
