package exam.test;
/*
 * 1. static�� ����� ��ü ���� ���� ����� �� �ִ�.
 */
class Member{
	static String name = "�����";
	static int age = 22; // static ����, class ����, ��������
	int count = 1; // �ʵ�, ��� ����
	
	public static void getMember() { // static
		System.out.println("��/��/��/��/ "+name);
		// System.out.println("count :"+count); 
		// ������. static�� static���� ����. count�� static�� �ƴϹǷ� ���� �޸𸮿� ����.
	}
	public void getMember2() { // non-static
		System.out.println("��/��/��/��/ "+name);
	}
} 
public class StaticExamTest1 {

	public static void main(String[] args) {
		/*Member m = new Member(); // ��ü �����ؾ� �� �� ����.
		m.getMember();*/
		
		Member.getMember(); // static ���� �� �޼ҵ尡 ����ִ����� �˷��ָ� �ٷ� �� �� ����.
		
		/*// static�� static���� ���Ѵ�.
		 * ������ �̸� �޸𸮿� �ö� �ִ� �޼ҵ�. �׷��� ����ƽ������ ���ϰ� ����ƽ������ ��ü ���� ���ϰ� ���� ����.
		Member.getMember2(); // static�� �ƴϴϱ� �޸𸮿� �÷��� ��� ��. ���� ��.*/
		Member m = new Member();
		m.getMember2(); // �̷��� �����.
		
		// static�� ��ü ���� �� ���൵ �ż� ����.
		// ������ ���� �� static���� �ϸ� �� ��. static���� ������ �ֵ��� �޸𸮿� �ö󰡴µ� class area�� �ö�. 
		// (�ݸ� new�� ���� �ֵ��� heap�� �ö�)
		// �׷��� ������ garbage collector�� ����� �ƴ�. û�Ҵ� heap�� ��. 
		// ��� �� static���� ��Ƶθ� û�Ҹ� �� ���ְ� �޸� ȿ������ �ް���.
		// �޸𸮰� �� ���� ���������� �� ������. �׷��� static�� �Ժη� ���� �� �ȴ�.
	}

}
