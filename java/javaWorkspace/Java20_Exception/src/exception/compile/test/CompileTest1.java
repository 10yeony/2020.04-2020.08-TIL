package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader; // java.lang�� ��� import

class FileReading{
	FileReading(){}
	public void readFile(String fileName) {
		// ���� C:\\kyh\\poem.txt�� ��� �� �־��µ� ���� ó�� �� ���ָ� ����.
		// ��θ� �� �ֵ� �� �� �ֵ� ������ ���� ó���ϰ� ����.
		try {
			FileReader fileReader = new FileReader(fileName); 
			// ���⿡�� ���ܰ� ������. 
			// FileNotFoundException =>
			// File �� ã�� ��(1. ã���� �ϴ� ������ ���� �� / 2. ���� �̸��� �߸� �־��ų� path�� �߸� �־��� ��)
			System.out.println("FileReader Creating");
		}catch(FileNotFoundException e) {
			e.printStackTrace(); // ���� ���� �� ���� �� �̷��� ����.
		}
		// ��ź ������ �� ���������� ��� �� try~catch
		
	}
}
public class CompileTest1 {
	public static void main(String[] args) {
		FileReading fr = new FileReading(); // ��ü ����
		
		//readFile ȣ��...
		String path = "C:\\kyh\\poem.txt";
		fr.readFile(path);
		System.out.println("readFile Calling....");
	}

}
