package exception.runtime.test;

public class RuntimeExceptionTest3 {
	public static void main(String[] args) {
		System.out.println("======= NullPointerException =======");
		String str = new String("Encore"); 
		str = null;
		try {
			System.out.println("str�� ������ �� :: " + str); // null
			System.out.println("str ���ڿ� ���� :: " + str.length()); 
		}catch(Exception e) {
			System.out.println("��Ҵ�...Exceptio"); // �ڽ� -> �θ�� ���� ��. �θ� -> �ڽ����� ���� �� ����.
		}/*catch(NullPointerException e) {
			System.out.println("��Ҵ�...NullPointerException");
		}*/finally {
			System.out.println("Always Print...");
		}
	}

}