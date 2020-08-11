package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader; // java.lang에 없어서 import

class FileReading{
	FileReading(){}
	public void readFile(String fileName) {
		// 내가 C:\\kyh\\poem.txt로 경로 잘 넣었는데 예외 처리 안 해주면 터짐.
		// 경로를 잘 넣든 잘 못 넣든 무조건 예외 처리하게 만듦.
		try {
			FileReader fileReader = new FileReader(fileName); 
			// 여기에서 예외가 터졌음. 
			// FileNotFoundException =>
			// File 못 찾을 때(1. 찾고자 하는 파일이 없을 때 / 2. 파일 이름을 잘못 넣었거나 path를 잘못 넣었을 때)
			System.out.println("FileReader Creating");
		}catch(FileNotFoundException e) {
			e.printStackTrace(); // 딱히 해줄 거 없을 때 이렇게 써줌.
		}
		// 폭탄 터졌을 때 직접적으로 잡는 게 try~catch
		
	}
}
public class CompileTest1 {
	public static void main(String[] args) {
		FileReading fr = new FileReading(); // 객체 생성
		
		//readFile 호출...
		String path = "C:\\kyh\\poem.txt";
		fr.readFile(path);
		System.out.println("readFile Calling....");
	}

}
