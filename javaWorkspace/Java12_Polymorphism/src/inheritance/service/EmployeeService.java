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
		Employee emp = null; // return 타입이 void가 아닐 경우 선언하고 들어갈 것.
		for(Employee e : ea) {
			if(e.getName().equals(name)) {
				emp = e;
			}
		}
		return emp;
	}	
	
	public int getAnnualSalary(Employee e) {
		int annualSalary = 0;
		annualSalary = (int)(e.getSalary()*12); //Salary가 double형이라서 정수 int형으로 바꿔줌.
		if(e instanceof Engineer) {
			Engineer eg = (Engineer)e; // getBonus는 Engineer에만 있어서 캐스팅해줘야 함.
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
