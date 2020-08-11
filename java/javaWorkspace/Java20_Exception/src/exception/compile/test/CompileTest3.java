package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader; // java.lang�� ��� import

class FileReading3{
	FileReading3(){}
	public void readFile(String fileName) throws FileNotFoundException{
			FileReader fileReader = new FileReader(fileName); 
			// FileReader�� ���� ���� �� �ƴ϶� ���� �����ϴ� ���̺귯��
			System.out.println("FileReader Creating");
	}
}
public class CompileTest3 {
	public static void main(String[] args) throws FileNotFoundException {
		// ���� ��ź�� ȣ���� ������ ���ư���. 
		// ������ JVM���� ȣ����. �׷��� ���� �޼ҵ带 ȣ���� JVM���� ���ư��� JVM�� �˾Ƽ� ó����.
		// ������ ������ ������ ���� JVM���� ����. �� ���� JVM�� ��ü�� ����.
		
		FileReading3 fr = new FileReading3(); // ��ü ����
		
		//readFile ȣ��...
		String path = "C:\\kyh\\poem.txt";
		fr.readFile(path);	
		
		System.out.println("readFile Calling....");
	}

}
// ���ܸ� ���� ó���ϴ� �� try~catch
// ������ �ٸ� ���� ó���ϰ� �ϴ� �� throw