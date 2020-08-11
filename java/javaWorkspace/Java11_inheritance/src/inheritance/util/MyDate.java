package inheritance.util;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// getDate() function ���� �ʿ䰡 ����.
	
	/*
	 * 	�޼ҵ� Overriding
	 * step 1. Object�� ����� �״�� �޾Ƽ�
	 * step 2. �� ����� �ڽ� ���ο��� �µ��� ���� ����.
	 */
	@Override // �̰� �մ�� �� ��.
	/*public String toString() {
		return super.toString(); 
		// super�� �θ� �ǹ���. ���� MyDate�� �θ�� Object(�� �߰��� �θ� �����Ƿ�)
		// Object ��ü�� �ִ� toString()�� ȣ��.
	}*/
	public String toString() {
		return year+"-"+month+"-"+day; 
	} // �θ� ����ϵ� �ڽĿ��� �°� ���. �� �� ���� ������.
	
}
