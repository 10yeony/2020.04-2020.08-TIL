/*
 * 사용자 정의 Exception
 * ::
 * User Exception
 * ::
 * 1. 기존의 라이브러리 예외 클래스를 사용하지 않고 직접 예외 클래스를 내가 정의해서 쓴다.
 * 2. 프로그램 상에서 특정한 조건일 때 내가 고의적으로 예외를 발생시키는 경우
 *      --> 강력한 제어문의 수단으로 사용
 *      
 * 예외는 보통 핸들링. 하지만 사용자 정의 예외는 특정한 값이 들어오면 그 아래를 수행 못하도록 내가 일부러 예외 발생시킴. 제어문처럼 사용.
 * 1번 의미보다 2번 의미가 사용자 정의 예외의 실질적 의미와 더 가까움.
 * 
 */

package exception.user.test;

import java.util.Scanner;

class User {
	public void go(int n) throws ArithmeticException {
		System.out.println("2. go()는 아랫부분에서 연산작용을 합니다... 분모가 0이면 안 됩니다.");
		int j = 111;
		if(n == 0) {
			throw new ArithmeticException();
			//내가 고의적으로 폭탄을 발생.... ArithmeticException (분모가 0일 때 발생하는 폭탄)
			//원래 예외 객체는 JVM이 만듦. 
			//사용자 정의 예외는 내가 JVM 대신에 예외 객체를 생성한다!
			//throw는 내가 예외 객체 생성할 때 new 앞에 붙인다.
			//(그런데  ArithmeticException은 이미 있는 예외. 진정한 의미의 사용자 정의 예외는 내가 직접 만듦.
			
			//던질 때는 throws 써서 메소드 선언부 뒤에 던짐. -> 메인 메소드로 날아감.
		}
		
		// 연산.... j/n (n은 0이 들어오면 안 됨)
	}
}
public class UserExceptionTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요>>");
		int num = sc.nextInt();
		
		User user = new User();
		try {
			System.out.println("1. go calling");
			user.go(num); // calling
		}catch(ArithmeticException e){ //직접 잡아서 throw 안해줘도 됨.
			System.out.println("Nice Catch...");
		}
		System.out.println("3. 모든 기능을 수행하고 정상적으로 종료합니다...");
	}

}

// User Exception은 Runtime 계열 예외.
// 컴파일할 때는 예외가 안 터지는데 실행할 때 터짐. 
// 컴파일 계열만 메인에서 JVM으로 던질 수 있다.

// 내가 만든 예외는 JVM으로 못 던진다. 왜냐하면 JVM이 만든 예외가 아니라 내가 만든 예외이기 때문.

// 컴파일 계열은 예외를 잡아서 종료시킴. 하지만 런타임 계열은 예외를 잡아서 다음으로 넘어감.
// 컴파일은 예외를 잡아놓고 가기 때문에 실행할 때 안 돈다.

// 컴파일 계열을 컴파일 때 에러가 나서 잡았음. 실행할 때 예외가 안 난다는 소리. 예외가 아예 안 나게 해서 돌림.

// ==> 정리 : 컴파일 계열은 무조건 다 잡아야 함. 런타임 계열은 사용자 정의 밖에 잡을 게 없음. 런타임 계열 나머지는 코드 수정하면 됨.