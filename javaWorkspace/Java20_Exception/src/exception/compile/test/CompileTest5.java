package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest5 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// ������ ���� ���� ����. ���� �θ� ������ IOException�� ������ ��.
		String path = "c:\\kyh\\poem.txt";
		FileReader fr = null;
		try {
			System.out.println("1. FileReader Ŭ���� ����");
			fr = new FileReader(path); 
			System.out.println("2. ������ ������ �о���Դϴ�.... read()...");
			fr.read();
			
		}finally {// �� �ڵ�� ���� ������ ���� ������ finally�� try ���� �� �� ����.
				fr.close(); //������ �̰� �� ���൵ ū ���� ������ �������� �̰� �� ���ָ� ū ���� �߻�.
		}
		// try~finally�� �� ���ְ� �׳� fr.close()�� fr.read() �ڿ� �̾ ����
		// ������ fr.read() ���� �߻��ϰ� throw�� ������ ����. fr.close()���� �� ���� ����.
		// ���� �߻��ϸ� �翬�� �Ʒ����� �� ���� ����. �ٵ� ���� ó�� ���ָ� ���������� ������ �Ű� ���� ó�� �� ���ָ� ������������ ����.
		// ���� ���� ������ �迭 ���� ����. UserExceptionTest1 ���� �ϴܿ� �ִ� ���� ����.
		// �׷��� finally�� �� ����� ��. close()�� ���ܿ� ������� ������ ����Ǿ�� �ϹǷ�.
	}

}

// ���� ó���� ��������. ���� ó��X.
// finally�� �� ��.


