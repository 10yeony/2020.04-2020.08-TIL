package covid.test;

import java.util.ArrayList;
import java.util.Scanner;

import covid.service.CovidOperationImpl;
import covid.util.Fever;
import covid.vo.child.Staff;
import covid.vo.child.Student;
import covid.vo.child.Teacher;
import covid.vo.parent.Visitor;

public class CovidOperationTest {
	public static void main(String[] args) {
		CovidOperationImpl service = new CovidOperationImpl();
		/*System.out.println("============�߰�=============");
		
		System.out.println("============����=============");
		service.deleteVistor("��ȣ��");
		service.deleteVistor("��ȣ��");
		System.out.println(service.getAllVisitors());
		System.out.println("============�̸� �Է��ϰ� ����ũ ���� Ȯ��=============");
		System.out.println(service.checkMask("�迬��"));
		System.out.println("============�̸� �Է��ϰ� ���� ������Ʈ=============");
		System.out.println(service.updateCondition("�迬��", "����"));
		System.out.println("============�̸� �Է��ϰ� ü�� ������Ʈ=============");
		System.out.println(service.updateCondition("�Ͻ���", new Fever(36.4, 35.9)));*/
		
		
		Scanner sc = new Scanner(System.in);
		
		aaa : while(true)
		{
			String menu = "";
			menu += "��ȣ�� �����ϼ���\n";
			menu += "1:�湮ȸ�� �߰�\n";
			menu += "2:��üȸ�� ��ȸ\n";
			menu += "3:�湮ȸ�� ����\n";
			menu += "4:����ũ ���� ���� ��ȸ\n";
			menu += "5:Ư�� �µ� �̻� �߿� ȸ�� ��ȸ\n";
			menu += "6:ü�� ������Ʈ\n";
			menu += "7: ���� ������Ʈ\n";
			menu += "0:������";

			System.out.println(menu);
			int number = sc.nextInt();
			
			switch(number)
			{
			case 0: 
				break aaa;
			case 1:
				service.addVisitor(new Visitor("�迬��", false, new Fever(35.9, 37.8)));
				service.addVisitor(new Visitor("������", true, new Fever(35.9, 36.5), "��ħ"));
				service.addVisitor(new Student("������", true, new Fever(37.9, 36.5), "����", 4, "�����а�"));
				service.addVisitor(new Staff("��ȣ��", false, new Fever(36.9, 36.5), 2000000, "�ü�������"));
				service.addVisitor(new Teacher("�Ͻ���", true, new Fever(36.5, 36.5), 30, "��������"));
				service.addVisitor(new Teacher("�Ͻ���", false, new Fever(36.5, 36.5), 30, "��������"));
				
				System.out.println("��ȣ ���� (1:Visitor / 2:Student / 3:Staff / 4:Teacher) : ");
				int num = sc.nextInt(); 
				
				if(num < 0 || 2 < num)
					continue;
				String symptom = null;
				System.out.println("�̸��� �Է��ϼ��� : ");
				String name = sc.next();
				System.out.println("����ũ ���� ���θ� �Է��ϼ��� : True / False");
				boolean mask = sc.nextBoolean();
				System.out.println("������ ������ ü���� �Է��ϼ���.");
				double temperature1 = sc.nextDouble();
				System.out.println("���Ŀ� ������ ü���� �Է��ϼ���.");
				double temperature2 = sc.nextDouble();
				System.out.println("���� Ư���� ������ �ֽ��ϱ�? : �� / �ƴϿ�");
				String answer = sc.next();
				if(answer.equals("��")) {
					System.out.println("������ �Է����ּ���. : ");
					symptom = sc.next();
				}
				else continue;
				
				if(num==1){
					if(answer.equals("�ƴϿ�")) {
						service.addVisitor(new Visitor(name, mask, new Fever(temperature1, temperature2)));
					}
					else if(answer.equals("��")) {
						service.addVisitor(new Visitor(name, mask, new Fever(temperature1, temperature2), symptom));
					}
				}
				else if(num == 2){
					System.out.println("���ǽ� ��ȣ�� �Է��ϼ���");
					int roomNum = sc.nextInt();
					System.out.println("������ �Է��ϼ���.");
					String major = sc.next();
					if(answer.equals("�ƴϿ�")) {
						service.addVisitor(new Student(name, mask, new Fever(temperature1, temperature2), roomNum, major));
					}
					else if(answer.equals("��")) {
						service.addVisitor(new Student(name, mask, new Fever(temperature1, temperature2), symptom, roomNum, major));
					}
				}
				else if(num == 3) {
					System.out.println("������ �Է��ϼ���");
					double salary = sc.nextDouble();
					System.out.println("�μ��� �Է��ϼ���");
					String dept = sc.next();
					if(answer.equals("�ƴϿ�")) {
						service.addVisitor(new Staff(name, mask, new Fever(temperature1, temperature2), salary, dept));
					}
					else if(answer.equals("��")) {
						service.addVisitor(new Staff(name, mask, new Fever(temperature1, temperature2), symptom, salary, dept));
					}
				}
				else if(num == 4) {
					System.out.println("����� �Է��ϼ���.");
					int career = sc.nextInt();
					System.out.println("�Ҽ��� �Է��ϼ���");
					String company = sc.next();
					if(answer.equals("�ƴϿ�")) {
						service.addVisitor(new Teacher(name, mask, new Fever(temperature1, temperature2), career, company));
					}
					else if(answer.equals("��")) {
						service.addVisitor(new Teacher(name, mask, new Fever(temperature1, temperature2), symptom, career, company));
					}
				}
				break;
				
			case 2:
				System.out.println(service.getAllVisitors());
				break;
				
			case 3:
				System.out.println("������ ȸ�� �̸��� �Է��ϼ���.");
				String name1 = sc.next();
				service.deleteVistor(name1);
				break;
				
			case 4:
				System.out.println("����ũ ���� ���θ� ��ȸ�� ȸ�� �̸��� �Է��ϼ���.");
				String name2 = sc.next();
				System.out.println(service.checkMask(name2));				
				break;
				
			case 5:
				System.out.println("��ȸ�� ü���� �Է��ϼ���.");
				double temperature3 = sc.nextDouble();
				System.out.println(service.overTemperature(temperature3));
				break;
				
			case 6:
				System.out.println("ȸ�� �̸��� �Է��ϼ���.");
				String name3 = sc.next();
				System.out.println("������ ������ ü���� �Է��ϼ���.");
				double temperature4 = sc.nextDouble();
				System.out.println("���Ŀ� ������ ü���� �Է��ϼ���.");
				double temperature5 = sc.nextDouble();
				System.out.println(service.updateCondition(name3, new Fever(temperature4, temperature5)));
				break;
			case 7:
				System.out.println("ȸ�� �̸��� �Է��ϼ���.");
				String name4 = sc.next();
				System.out.println("������ �Է��ϼ���.");
				String symptom2 = sc.next();
				System.out.println(service.updateCondition(name4, symptom2));
				break;
			}
		}	
	}
}
