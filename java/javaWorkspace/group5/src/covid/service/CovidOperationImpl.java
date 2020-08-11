package covid.service;

import java.util.ArrayList;

import covid.util.Fever;
import covid.vo.parent.Visitor;

public class CovidOperationImpl implements CovidOperation {
	ArrayList<Visitor> visitors = new ArrayList<>();

	@Override
	public void addVisitor(Visitor v) {	
		int check = 0;
		for(Visitor vi : visitors) {
			if(vi.getName().equals(v.getName())) {
				check = 1;
				System.out.println("�̹� �����ϴ� ȸ���Դϴ�.");
			}
		}
		if(check == 0) {
			visitors.add(v);
			System.out.println(v.getName()+"���� ȸ������ ��ϵǼ̽��ϴ�.");
		}
	}

	@Override
	public ArrayList<Visitor> getAllVisitors() {
		return visitors;
	}

	@Override
	public void deleteVistor(String name) {
		int check = 0;
		for(Visitor v : visitors) {
			if(v.getName().equals(name)) {
				check = 1;
				visitors.remove(v);
				System.out.println("���������� ȸ������ �����Ǽ̽��ϴ�.");
			}
		}
		if(check == 0) System.out.println("�̹� �����ϴ� ȸ���Դϴ�.");
	}

	@Override
	public boolean checkMask(String name) {
		Visitor temp = null;
		for(Visitor v : visitors) {
			if(v.getName().equals(name)) {
				temp = v;
			}
		}
		return temp.isMask();
	}

	@Override
	public ArrayList<Visitor> overTemperature(double temperature) {
		ArrayList<Visitor> temp = new ArrayList<>();
		for(Visitor v : visitors) {
			if(v.getFever().getTemperature1() > 37.5) {
				temp.add(v);
			}
			else if(v.getFever().getTemperature2() > 37.5) {
				temp.add(v);
			}
		}
		return temp;
	}

	@Override
	public Visitor updateCondition(String name, Fever fever) {
		Visitor temp = null;
		for(Visitor v : visitors) {
			if(v.getName().equals(name)) {
				v.setFever(fever);
				temp = v;
			}
		}
		return temp;
	}

	@Override
	public Visitor updateCondition(String name, String symptom) {
		Visitor temp = null;
		for(Visitor v : visitors) {
			if(v.getName().equals(name)) {
				v.setSymptom(symptom);
				temp = v;
			}
		}
		return temp;
	}
}
