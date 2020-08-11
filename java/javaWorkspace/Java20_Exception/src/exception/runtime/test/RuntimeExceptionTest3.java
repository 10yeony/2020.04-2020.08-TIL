package exception.runtime.test;

public class RuntimeExceptionTest3 {
	public static void main(String[] args) {
		System.out.println("======= NullPointerException =======");
		String str = new String("Encore"); 
		str = null;
		try {
			System.out.println("str의 데이터 값 :: " + str); // null
			System.out.println("str 문자열 길이 :: " + str.length()); 
		}catch(Exception e) {
			System.out.println("잡았다...Exceptio"); // 자식 -> 부모로 가야 함. 부모 -> 자식으로 예외 못 잡음.
		}/*catch(NullPointerException e) {
			System.out.println("잡았다...NullPointerException");
		}*/finally {
			System.out.println("Always Print...");
		}
	}

}