package exam.test;
/*
 * 
 * final Ű���� + static Ű����
 * final :: ���� �������̾�~~~
 * final + ���� : ���� ������ ������~~~ 
 * --> ����� �ǹ�(�� �̻� �ٲ� �� ����. ������ ��. �̷� ������ ��ü���� �����ؼ� ���������� ���.)
 * ����� �̷� ������ ��. static final int COUNTER = 1;
 * final static int COUNTER = 1;�� �ص� ��� ����.
 * ����� ���� �빮�ڷ� ���� ���ڳ��� ����ٷ� ����. ����� ������ ���� ���� ��. 
 * final + Ŭ���� : ���� ������ Ŭ������~~ --> �� �̻� �ڽ��� ���� �ʰڴ�. ��ӱ���.
 * final + �޼ҵ� : ���� ������ �޼ҵ��~~ --> �������̵� ����.(���� ���ľ�����!)
 */
class A{
	public final static int BASE_SALARY = 300;
	// �ٲ� �� �����Ƿ� final
	// �����ϹǷ� static
	// �������� ���� �� �� �ְ� �����Ϸ��� �� ��Ȯ���� public�� ��. ���� ���ε�.
	public final String test() {
		return "Overriding ����";
	}	
}

final class B { // ��ӱ���
	
}

/*class C extends B{
	
} ������. Ŭ���� B�� final�� �پ����Ƿ� �� �� ��Ӹ���*/

class D extends A{
	/*public final String test() {
		return "Overriding ����";
	} �� �׷��� �� �� �ִµ� �̷��� �ڽ����� �����Դٴ� �� ���ľ��ڴٴ� �Ҹ��ε�
	���ľ��� ����� �Ҹ�. �׷��� ������ ��.*/	
}

public class StaticExamTest4 {
	
	public static void main(String[] args) {
		
	}

}
