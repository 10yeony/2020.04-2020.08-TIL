package thread.step2.test;

import thread.step2.ComeThread;
import thread.step2.GoThread;

public class GoComeThreadTest {
	public static void main(String[] args) {
		GoThread go2 = new GoThread();
		ComeThread come2 = new ComeThread();
		
		Thread tgo = new Thread(go2, "GoThread"); //Runnable 상속받은 객체를 인자값으로 받으면 됨.
		// 스레드 클래스 API에서 생성자 참고. 
		Thread tcome = new Thread(come2, "ComeThread");
		
		tgo.start();
		tcome.start();
		
	}

}
