package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest4 {
	public static void main(String[] args) {
		String path = "c:\\kyh\\poem.txt";
		FileReader fr = null; //���⿡�� ���� ��������� {} �ȿ��� �� �� �� ����.
		try {
			System.out.println("1. FileReader Ŭ���� ����"); // ������ �о���̷��� ������ �о���̴� ��ü�� ���� ������ ��.
			fr = new FileReader(path); // �����ϴ� ���� ���������� ����. ���� ��� ������ �Դٰ���.
			System.out.println("2. ������ ������ �о���Դϴ�.... read()...");
			fr.read(); //FileReader Ŭ������ read()��� �޼ҵ带 ������ ����.
			
		}catch(FileNotFoundException e) {// �ڽ� ���ܺ��� ���
			e.printStackTrace();
		}catch(IOException e) {// �θ� ���� ��ƾ� ��
			e.printStackTrace();
		}finally {
			try {
				fr.close(); //���������� ��ٴ�... 
				// �ٵ� �̰͵� ��ź ������ �Ǿ� �־ ���� �� ���� ó������� ��.
			}catch(IOException e) {
				
			}
			 
		}
	}

}
