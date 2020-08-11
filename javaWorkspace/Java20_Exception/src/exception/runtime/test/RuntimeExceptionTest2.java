package exception.runtime.test;
/*
 * NullPointerException :: ---> �ڵ� �ۼ��� �� ���� ���� ������ ����. null�� ������...
 * ��ü �������� �ʰ� ��ü�� ����� �����Ϸ��� �� �� �߻��ϴ� ����.....
 * ��ü �������� �ʰ� == null (null�� ������ ��ü�� �����Ϸ��� �� ��.)
 * ��ü �������� �ʰ� �����Ϸ��� ������ ������� ã���� ��.
 * 
 * catch�� ������ �� �� �ִ�.
 * ������ �� �߿��� �� �ѹ��� ����ȴ�...
 * 
 * finally
 * ::
 * ���ܿ� �������(���ܰ� �߻��ϵ� �� �ϵ�) ������ ����Ǿ����� �ϴ� �ڵ尡 �ִٸ�...
 * �� �ȿ��� ����־�� �Ѵ�.
 */
public class RuntimeExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("======= NullPointerException =======");
		String str1 = "Encore"; // ������ String�� Ư���ؼ� ���±��� String ��ü ������ �� �̷��� ������...
		// �̷��� Literal Pool�� �ö�. ��ġ ���ú���ó�� ���±��� �����.
		String str = new String("Encore"); // �̰� ������. Heap�� �ö�.
		System.out.println(str); //Encore 
		System.out.println(str.toString()); // ���� ����.
		// Object������ ��ü �ּҰ��ε� String������ �θ𿡰Լ� ��ӹ޾Ƽ� String���� ��µǰԲ� Ȯ��.
		// String������ toString�� �������̵��ؼ� ��.
		
		str = null;
		try {
			System.out.println("str�� ������ �� :: " + str); // null
			System.out.println("str ���ڿ� ���� :: " + str.length()); // ���� �߻� 
		}catch(ArrayIndexOutOfBoundsException e) {// �� ����
			System.out.println("��Ҵ�...1");
		}catch(NullPointerException e) {//����.
			System.out.println("��Ҵ�...2");
		}catch(Exception e) {// �̹� ������ ��ҹǷ� ������� �� ������. catch�� �� �ѹ��� �����.
			System.out.println("��Ҵ�...3");
		}finally {// ������ �߿��� ��
			System.out.println("Always Print...");
		}
	}

}
/*
1. ���� �߻��ڵ� �ۼ�... + ���ܰ� �߻� ����.
 try + finally
 
2. ���� �߻��ڵ� �ۼ�... + ���� �߻� + �� ���ܸ� �� ����.
 catch + finally

3. ���� �߻��ڵ� �ۼ�... + ���� �߻� + �� ���ܸ� �� ������.
 finally

 finally�� �ַ� �ִ� �ڵ�
 --> �ڿ��� �ݳ��ϴ� �ڵ�.... close()
 --> ������ ���� �� �� ��. JDBC ���� ���� ��. close() ������ �߿�. 
      �����ϰ� �� Ʈ�µ� ���� ���ϰ� �������� �ݾƾ� �ϴµ�, �ڿ��� ���� �ݴ� ��.
      �ڿ��� ������� �ʵ���, ���Ǿ ������������ �ʵ��� close ����.
     �������� ���� �߰��� ���� �߻��ϵ� �� �ϵ� ���ִ� ��. �ѹ� �� �Ŵ� ������ �ݾ���� ��.
    
 finally�� �������� �ʴ� ��찡 �ִ�.
 1) �� �ȿ��� �ٽ� ���ܰ� �߻��� ��... �ٽ� �� ���� try~catch�� ���ξ� �Ѵ�.
 */