package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest4 {
	public static void main(String[] args) {
		String path = "c:\\kyh\\poem.txt";
		FileReader fr = null; //여기에서 먼저 선언해줘야 {} 안에서 다 쓸 수 있음.
		try {
			System.out.println("1. FileReader 클래스 생성"); // 파일을 읽어들이려면 파일을 읽어들이는 객체를 먼저 만들어야 함.
			fr = new FileReader(path); // 생성하는 것은 수도꼭지를 연다. 관을 열어서 데이터 왔다갔다.
			System.out.println("2. 파일의 내용을 읽어들입니다.... read()...");
			fr.read(); //FileReader 클래스가 read()라는 메소드를 가지고 있음.
			
		}catch(FileNotFoundException e) {// 자식 예외부터 잡고
			e.printStackTrace();
		}catch(IOException e) {// 부모 예외 잡아야 함
			e.printStackTrace();
		}finally {
			try {
				fr.close(); //수도꼭지를 잠근다... 
				// 근데 이것도 폭탄 터지게 되어 있어서 따로 또 예외 처리해줘야 함.
			}catch(IOException e) {
				
			}
			 
		}
	}

}
