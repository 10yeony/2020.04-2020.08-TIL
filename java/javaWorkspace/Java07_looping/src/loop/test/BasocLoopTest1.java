package loop.test;
/*
 * �ݺ���
 * ::
 * �ش��ϴ� ������ ���� ���� �ڵ� ����� ��� �����ϴ� ����
 * for / while / do~while
 * �� �� �ִ���/������ Ƚ���� �� �� for���� ���� empty�� �� ������ ������ ���� �� while���� ��.
 * do~while�� �ѹ��� ������ ����.
 */

public class BasocLoopTest1 {

	public static void main(String[] args) {
		System.out.println("=========== for ============");
		for(int i=0; i<=10; i++) {//
			System.out.println(i+".Hello..For Loop..");
		}
		
		System.out.println("=========== while ============");
		int i=10;
		while (i>0) {
			System.out.println(i+".Hello..For Loop..");
			i--;
		}
		
		System.out.println("===========do~while==========");
		int j=0;
		do {
			System.out.println(j+".Always Print..");
			j++; // ������
		}while(j<10);
	}

}
