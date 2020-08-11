package exception.runtime.test;
/*
 * ���� �߻� �� �ϸ�.... try�� ����
 * ���� �߻��ϸ�... 
 *     +
 * �߻��� ���ܷ� �� ������... catch�� ����
 */
public class RuntimeExceptionTest1 {
	public static void main(String[] args) {
		String[] str = {
			"Hello Java",
			"No I mean it",
			"Nice to meet you"
		};
		
		int i = 0;
		/*while(i <= 3) {
			System.out.println(str[i]); // ���ư��µ� Ư���� ������ ������ �� ���װ� ����. �� ��µǴٰ� i�� 3�� �� ���� ����.
			// 3�� ������ �� ArrayIndexOutOfBoundsException ��ü�� ��������� ����.
			// ���ư��� ���ư�. ���������� ���Ḧ �� ��.
			i++;
		}
		// Runtime �迭�� �ڵ带 �����ϸ� ��. i < 3���� �ٲٸ� ��. 
*/		
		while(i <= 3) {//0,1,2,3
			try {//���� �߻� �� �ϸ� �� �κ� ����... // 0,1,2 // 3�� �� ��� ����. �׷��� try�� ���� ���ϰ� catch������ ��.
				System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {// 3�� ��.
				// ArrayIndexOutOfBoundsException�� Exception�� �θ��̹Ƿ� Exception���� ���� ���� ����.
				// ������ ����� Exception�� Exception���� �� ����.
				// try�� ����Ǹ� catch�� ����ȵ�. ���� �߻� �� �ϸ� ����� ���� ����.
				System.out.println("Nice Catch!!");
			}
			i++;
		}
	}

}
