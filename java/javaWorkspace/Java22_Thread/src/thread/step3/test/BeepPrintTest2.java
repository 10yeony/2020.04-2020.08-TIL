/*
 * BeepPrintTest1 실행클래스... 하나의 프로세스
 * 이 안에는 메인스레드 하나밖에 없었다...
 * 병렬 작업이 불가능했다.
 * 
 * ---------------------------------
 * BeepPrintTest2 실행클래스..... 하나의 프로세스
 * 이 안에 메인스레드 + 작업스레드 하나 더 추가
 * 1) 메인 스레드 : beep()를 5번 ---- 경고음 5번 	발생 
 * 2) 작업 스레드 : BeepPrintThread ---- 띵을 5번 출력
 * 
 */
package thread.step3.test;

import java.awt.Toolkit;

class BeepPrintThread extends Thread{
	public void run() {
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

public class BeepPrintTest2 {
	public static void main(String[] args) {
		BeepPrintThread beepT = new BeepPrintThread();
		beepT.start(); // 여기를 기점으로 하나는 위의 run()을 실행하고 하나는 밑을 실행함.
		// start가 병렬적인 작업이 실행되는 시점.
		
		Toolkit tool = Toolkit.getDefaultToolkit(); // static임.
		// 경보음 5번 울리는 작업
		for(int i = 0; i < 5; i++) {
			tool.beep(); //경보음을 울려줌. 근데 이것만 쓰면 너무 빨리 지나가서 5번으로 안 들리고 1번으로 들림.
			
			try {
				Thread.sleep(500); // 0.5초로 재움.
			} catch (InterruptedException e) {
				
			}
		}
	}

}

// 경고음을 발생시키고 / 동시에 경고음을 콘솔로 프린팅하는 작업 ==> 여기서는 불가능.
