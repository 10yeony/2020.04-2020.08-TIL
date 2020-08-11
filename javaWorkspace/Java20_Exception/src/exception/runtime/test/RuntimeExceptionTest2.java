package exception.runtime.test;
/*
 * NullPointerException :: ---> 코드 작성할 때 가장 많이 만나는 예외. null을 만나는...
 * 객체 생성하지 않고 객체의 멤버에 접근하려고 할 때 발생하는 예외.....
 * 객체 생성하지 않고 == null (null을 가지고 객체를 생성하려고 할 때.)
 * 객체 생성하지 않고 접근하려는 라인이 어디인지 찾으면 됨.
 * 
 * catch는 여러번 할 수 있다.
 * 하지만 그 중에서 단 한번만 수행된다...
 * 
 * finally
 * ::
 * 예외와 상관없이(예외가 발생하든 안 하든) 무조건 수행되어져야 하는 코드가 있다면...
 * 이 안에다 집어넣어야 한다.
 */
public class RuntimeExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("======= NullPointerException =======");
		String str1 = "Encore"; // 워낙에 String이 특이해서 여태까지 String 객체 생성할 때 이렇게 했지만...
		// 이러면 Literal Pool에 올라감. 마치 로컬변수처럼 여태까지 사용함.
		String str = new String("Encore"); // 이게 정법임. Heap에 올라감.
		System.out.println(str); //Encore 
		System.out.println(str.toString()); // 위와 같음.
		// Object에서는 객체 주소값인데 String에서는 부모에게서 상속받아서 String으로 출력되게끔 확장.
		// String에서는 toString을 오버라이딩해서 씀.
		
		str = null;
		try {
			System.out.println("str의 데이터 값 :: " + str); // null
			System.out.println("str 문자열 길이 :: " + str.length()); // 예외 발생 
		}catch(ArrayIndexOutOfBoundsException e) {// 못 잡음
			System.out.println("잡았다...1");
		}catch(NullPointerException e) {//잡음.
			System.out.println("잡았다...2");
		}catch(Exception e) {// 이미 위에서 잡았므로 여기까지 안 내려옴. catch는 단 한번만 수행됨.
			System.out.println("잡았다...3");
		}finally {// 굉장히 중요한 애
			System.out.println("Always Print...");
		}
	}

}
/*
1. 예외 발생코드 작성... + 예외가 발생 안함.
 try + finally
 
2. 예외 발생코드 작성... + 예외 발생 + 그 예외를 잘 잡음.
 catch + finally

3. 예외 발생코드 작성... + 예외 발생 + 그 예외를 잘 못잡음.
 finally

 finally에 주로 넣는 코드
 --> 자원을 반납하는 코드.... close()
 --> 지금은 이해 안 갈 것. JDBC 가서 만날 것. close() 굉장히 중요. 
      세수하고 물 트는데 세수 다하고 수도꼭지 닫아야 하는데, 자원을 쓰고 닫는 것.
      자원이 낭비되지 않도록, 고갈되어서 끊어져버리지 않도록 close 해줌.
     수도꼭지 쓰고 중간에 예외 발생하든 안 하든 꺼주는 것. 한번 연 거는 무조건 닫아줘야 함.
    
 finally가 동작하지 않는 경우가 있다.
 1) 이 안에서 다시 예외가 발생할 때... 다시 이 안을 try~catch로 감싸야 한다.
 */