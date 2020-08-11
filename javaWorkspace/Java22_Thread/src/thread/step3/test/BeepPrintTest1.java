/*
 * 해당 코드에서는 별도의 스레드를 작성하지 않고 실행....
 * 경고음을 발생시키고 / 동시에 경고음을 콘솔로 프린팅하는 작업 ==> 이런 작업을 병렬적인 작업이라고 함.
 * 두 가지 일을 main 아래에서 처리하도록 할 것이다.
 */
package thread.step3.test;

import java.awt.Toolkit;

public class BeepPrintTest1 {
	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit(); // static임.
		// 경보음 5번 울리는 작업
		for(int i = 0; i < 5; i++) {
			tool.beep(); //경보음을 울려줌. 근데 이것만 쓰면 너무 빨리 지나가서 5번으로 안 들리고 1번으로 들림.
			try {
				Thread.sleep(500); // 0.5초로 재움.
			} catch (InterruptedException e) {
				
			}
		}
		
		// 띵띵띵띵띵을 5번 출력하는 작업
		for(int i = 0; i < 5; i++) {
			System.out.println("띵~~~");
			try {
				Thread.sleep(500); // 0.5초로 재움.
			} catch (InterruptedException e) {
				
			}
		}
	}

}
// 경고음을 발생시키고 / 동시에 경고음을 콘솔로 프린팅하는 작업 ==> 여기서는 불가능.
