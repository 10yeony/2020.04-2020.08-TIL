package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader; // java.lang�� ��� import

class FileReading2{
	FileReading2(){}
	public void readFile(String fileName) throws FileNotFoundException{
		// ��ź�� ���� ó���ϴ� ���� try~catch.
		// ������ ��ź�� ������ ����� ����(�� ���� ��).
		// ������ ��ź�� �޼ҵ带 ȣ���� ������ ���ư�. 
			FileReader fileReader = new FileReader(fileName); 
			System.out.println("FileReader Creating");
	}
}
public class CompileTest2 {
	public static void main(String[] args) {
		FileReading2 fr = new FileReading2(); // ��ü ����
		
		//readFile ȣ��...
		String path = "C:\\kyh\\poem.txt";
		try { // ���ƿ� ��ź�� ���⿡�� ó����. 
			fr.readFile(path);	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("readFile Calling....");
	}

}
// ���ܸ� ���� ó���ϴ� �� try~catch
// ������ �ٸ� ���� ó���ϰ� �ϴ� �� throw