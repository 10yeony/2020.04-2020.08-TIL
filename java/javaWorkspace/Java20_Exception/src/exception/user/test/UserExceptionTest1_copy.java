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
 */

package exception.user.test;

import java.util.Scanner;

class ZeroBoom extends Exception{
	ZeroBoom(){
		this("This is ZeroBoomException");
		// 생성자 앞의 this는 이 인자값을 가지는 또 다른 생성자 호출
		// 그러면 아래에 있는 생성자로 가는데 결국 부모 생성자로 가게 됨.
	}
	ZeroBoom(String message){
		super(message); // super는 Exception
		// 생성자 앞의 super는 부모 생성자 호출
	}
}

class User2 {
	public void go(int n) throws ZeroBoom {
		System.out.println("2. go()는 아랫부분에서 연산작용을 합니다... 분모가 0이면 안 됩니다.");
		int j = 111;
		if(n == 0) {
			// 내가 고의적으로 폭탄을 발생
			//throw new ZeroBoom(); 
			// 제로붐 생성하면 생성자 호출됨. 여기서는 기본 생성자로 만듦.
			
			throw new ZeroBoom("분모가 0이면 터집니다!!!");
			// 위 코드보다 이렇게 넣는 게 나음.
			// 자바 API 보면 생성자에 디폴드로도 만들 수 있지만 스트링 넣어서 만들 수도 있음.
		}
		
		// 연산.... j/n (n은 0이 들어오면 안 됨)
	}
}
public class UserExceptionTest1_copy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요>>");
		int num = sc.nextInt();
		
		User2 user = new User2();
		try {
			System.out.println("1. go calling");
			user.go(num); // calling
		}catch(ZeroBoom e){ //직접 잡아서 throw 안해줘도 됨.
			// e.printStackTrace(); 
			// 몇 년 전까지 이걸 무조건 여기에 썼음.
			// 예외가 어디에서 발생했는지 자취를 따라가서 몇 라인에 왜 에러가 났는지 출력해줌.
			// 개발자한테는 에러가 어디에서 났는지 알 수 있어서 좋음. 하지만 저 코드가 보안상 굉장히 취약함.
			// 메소드보다 저걸 쓰면 해커들이 저걸 따서 보안상의 치명적인 구멍을 만듦.(해커들이 잘 활용)
			// 방법 1. 절대로 배포할 때는 쓰지 말고 개발할 때만 쓴다. 개발할 때만 쓰고 배포할 때는 주석 처리한다.
			// 방법 2. 아예 안 쓴다. 그럼 뭘 쓴다? => getMessage 또는 System.out.println()
			System.out.println(e.getMessage());
			
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