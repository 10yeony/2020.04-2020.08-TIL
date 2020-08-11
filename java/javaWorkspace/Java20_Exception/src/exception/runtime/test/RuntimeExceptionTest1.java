package exception.runtime.test;
/*
 * 예외 발생 안 하면.... try문 수행
 * 예외 발생하면... 
 *     +
 * 발생한 예외로 잘 잡으면... catch문 수행
 */
public class RuntimeExceptionTest1 {
	public static void main(String[] args) {
		String[] str = {
			"Hello Java",
			"No I mean it",
			"Nice to meet you"
		};
		
		int i = 0;
		/*while(i <= 3) {
			System.out.println(str[i]); // 돌아가는데 특별한 라인을 만났을 때 버그가 터짐. 잘 출력되다가 i가 3일 때 버그 터짐.
			// 3을 만났을 때 ArrayIndexOutOfBoundsException 객체가 만들어져서 터짐.
			// 돌아가긴 돌아감. 비정상적인 종료를 할 뿐.
			i++;
		}
		// Runtime 계열은 코드를 수정하면 됨. i < 3으로 바꾸면 됨. 
*/		
		while(i <= 3) {//0,1,2,3
			try {//예외 발생 안 하면 이 부분 수행... // 0,1,2 // 3일 때 사건 터짐. 그래서 try문 수행 못하고 catch문으로 감.
				System.out.println(str[i]);
			}catch(ArrayIndexOutOfBoundsException e) {// 3일 때.
				// ArrayIndexOutOfBoundsException은 Exception이 부모이므로 Exception으로 잡을 수도 있음.
				// 하지만 명백한 Exception은 Exception으로 안 잡음.
				// try가 실행되면 catch는 실행안됨. 예외 발생 안 하면 여기는 실행 안함.
				System.out.println("Nice Catch!!");
			}
			i++;
		}
	}

}
