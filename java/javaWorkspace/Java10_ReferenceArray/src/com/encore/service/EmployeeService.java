package com.encore.service;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeService {
	Manager[ ] ms; 
	int midx; // Manager 타입의 배열의 index
	// 클래스 바로 아래 선언된 int 필드는 기본값 0을 가진다. 따라서 따로 0으로 초기화해주지 않아도 됨.
	// 하지만 지역변수일 경우 초기화를 꼭 해줘야 함.
	
	Engineer[ ] egs;
	int egidx;	

	public EmployeeService(int size){
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	public void addManager(Manager m) {	
		ms[midx++] = m;
	}
	public void addEngineer(Engineer eg) {	
		egs[egidx++] = eg;
	}
	public void deleteManager(String name) {	
		for(int i=0; i<midx; i++) {
			if(ms[i].getName().equals(name)) {
				for(int j=i; j<midx; j++) {
					ms[j] = ms[j+1];
				}
				ms[midx] = null;
				midx--; // 사람이 삭제되었으므로 인덱스 감소
			}
		}
	}
	public void deleteEngineer(String name) {
		for(int i=0; i<egidx; i++) {
			if(egs[i].getName().equals(name)) {
				for(int j=i; j<egidx; j++) {
					egs[j] = egs[j+1];
				}
				egs[egidx] = null;
				egidx--;
			}
		}
	}
	public void updateManager(double salary, String dept,int deptno,  String name) {	
		for(Manager manager : ms) {	
			if(manager==null) continue;
			if(manager.getName().equals(name)) {
				manager.setSalary(salary);
				manager.setDept(dept);	
				manager.setDeptno(deptno);				
			}			
		}
	}
	public void updateEngineer(Engineer eg) {	
		for(Engineer engineer : egs) {
			if(engineer==null) continue;
			if(engineer.getName().equals(eg.getName())) {
				engineer.setBirthDate(eg.getBirthDate());
				engineer.setBonus(eg.getBonus());
				engineer.setSalary(eg.getSalary());
				engineer.setTech(eg.getTech());
			}
		}
	}	
	//Method Overloading 오버로딩 기법
	/*
	 * 하는 일은 똑같은데(둘 다 메소드 이름은 findManager)... 
	 * 처리하는 데이터를 달리할 때 쓰는 기법(argument list는 다름. String과 int로 달리함.)
	 * 메소드의 통일감을 강조하면서도 서로 다른 데이터를 처리할 수 있게끔 해준다.
	 */
	public Manager findManager(String name) {
		Manager m = null;
		for(Manager manager : ms) {
			if(manager==null) continue;			
			if(manager.getName().equals(name))
				m = manager;
		}
		return m;
	}
	public Manager[ ] findManager(int deptno) {
		// 메소드 이름을 findManagerByName이라고도 할 수 있지만 
		// 인자값(String name)만으로도 유추할 수 있음. 그게 더 간결.
		Manager[ ] temp = new Manager[ms.length];
		int count = 0;
		for(Manager manager : ms) {
			if(manager==null) continue;
			if(manager.getDeptno()==deptno) {
				temp[count++] = manager;
			}
		}
		return temp;
	}
	//추가
	public void printManagers() {		
		for(Manager m : ms) {
			if(m!=null)
			System.out.println(m.getDetails());
		}
	}
	public void printEngineers() {
		for(Engineer e : egs) {
			if(e!=null)
			System.out.println(e.getDetails());
		}
	}
}







