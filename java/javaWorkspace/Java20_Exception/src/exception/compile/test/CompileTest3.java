package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader; // java.lang에 없어서 import

class FileReading3{
	FileReading3(){}
	public void readFile(String fileName) throws FileNotFoundException{
			FileReader fileReader = new FileReader(fileName); 
			// FileReader는 내가 만든 게 아니라 원래 제공하는 라이브러리
			System.out.println("FileReader Creating");
	}
}
public class CompileTest3 {
	public static void main(String[] args) throws FileNotFoundException {
		// 예외 폭탄은 호출한 곳으로 날아간다. 
		// 메인은 JVM에서 호출함. 그래서 메인 메소드를 호출한 JVM으로 날아가고 JVM이 알아서 처리함.
		// 던지고 던지고 던지다 보면 JVM으로 간다. 그 말은 JVM이 객체를 만듦.
		
		FileReading3 fr = new FileReading3(); // 객체 생성
		
		//readFile 호출...
		String path = "C:\\kyh\\poem.txt";
		fr.readFile(path);	
		
		System.out.println("readFile Calling....");
	}

}
// 예외를 직접 처리하는 게 try~catch
// 던져서 다른 데서 처리하게 하는 게 throw