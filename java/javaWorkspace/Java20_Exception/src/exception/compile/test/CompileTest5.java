package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest5 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// 여러개 던질 수도 있음. 물론 부모 예외인 IOException만 던져도 됨.
		String path = "c:\\kyh\\poem.txt";
		FileReader fr = null;
		try {
			System.out.println("1. FileReader 클래스 생성");
			fr = new FileReader(path); 
			System.out.println("2. 파일의 내용을 읽어들입니다.... read()...");
			fr.read();
			
		}finally {// 위 코드들 예외 던져서 문제 없지만 finally는 try 없이 쓸 수 없음.
				fr.close(); //지금은 이거 안 해줘도 큰 문제 없지만 현업에서 이거 안 해주면 큰 문제 발생.
		}
		// try~finally를 안 해주고 그냥 fr.close()를 fr.read() 뒤에 이어서 쓰면
		// 위에서 fr.read() 예외 발생하고 throw로 던지고 끝임. fr.close()까지 안 가고 끝임.
		// 예외 발생하면 당연히 아래까지 안 가고 끝남. 근데 예외 처리 해주면 정상적으로 끝나는 거고 예외 처리 안 해주면 비정상적으로 종료.
		// 위의 말은 컴파일 계열 예외 한정. UserExceptionTest1 가장 하단에 있는 설명 참고.
		// 그래서 finally를 꼭 해줘야 함. close()는 예외와 상관없이 무조건 실행되어야 하므로.
	}

}

// 예외 처리는 던져버림. 직접 처리X.
// finally만 쓴 것.


