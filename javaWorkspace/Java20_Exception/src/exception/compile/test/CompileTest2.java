package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader; // java.lang에 없어서 import

class FileReading2{
	FileReading2(){}
	public void readFile(String fileName) throws FileNotFoundException{
		// 폭탄을 직접 처리하는 것은 try~catch.
		// 하지만 폭탄을 던지는 방법도 있음(더 많이 씀).
		// 던져진 폭탄은 메소드를 호출한 곳으로 날아감. 
			FileReader fileReader = new FileReader(fileName); 
			System.out.println("FileReader Creating");
	}
}
public class CompileTest2 {
	public static void main(String[] args) {
		FileReading2 fr = new FileReading2(); // 객체 생성
		
		//readFile 호출...
		String path = "C:\\kyh\\poem.txt";
		try { // 날아온 폭탄은 여기에서 처리함. 
			fr.readFile(path);	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("readFile Calling....");
	}

}
// 예외를 직접 처리하는 게 try~catch
// 던져서 다른 데서 처리하게 하는 게 throw