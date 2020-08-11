package exam.test;
/*
 * 
 * final 키워드 + static 키워드
 * final :: 내가 마지막이야~~~
 * final + 변수 : 내가 마지막 변수야~~~ 
 * --> 상수를 의미(더 이상 바꿀 수 없음. 고정된 값. 이런 값들은 객체들이 공유해서 범용적으로 사용.)
 * 상수는 이런 식으로 씀. static final int COUNTER = 1;
 * final static int COUNTER = 1;로 해도 상관 없음.
 * 상수는 전부 대문자로 쓰고 문자끼리 언더바로 연결. 상수는 무조건 눈에 띄어야 함. 
 * final + 클래스 : 내가 마지막 클래스야~~ --> 더 이상 자식을 갖지 않겠다. 상속금지.
 * final + 메소드 : 내가 마지막 메소드야~~ --> 오버라이딩 금지.(나를 고쳐쓰지마!)
 */
class A{
	public final static int BASE_SALARY = 300;
	// 바꿀 수 없으므로 final
	// 공유하므로 static
	// 여기저기 갖다 쓸 수 있게 공용하려면 더 정확히는 public도 씀. 오픈 마인드.
	public final String test() {
		return "Overriding 금지";
	}	
}

final class B { // 상속금지
	
}

/*class C extends B{
	
} 에러뜸. 클래스 B에 final이 붙었으므로 너 걔 상속못해*/

class D extends A{
	/*public final String test() {
		return "Overriding 금지";
	} 안 그래도 쓸 수 있는데 이렇게 자식한테 가져왔다는 건 고쳐쓰겠다는 소리인데
	고쳐쓰지 말라는 소리. 그래서 에러가 뜸.*/	
}

public class StaticExamTest4 {
	
	public static void main(String[] args) {
		
	}

}
