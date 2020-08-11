package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * 메인스레드만 가동되는 로직...
 * 동시작업이 안된다.
 * 로또번호를 입력받는 작업과
 * 카운팅 작업이 병렬적으로 진행되어야 한다.
 * ---------------------------
 * 10초 안에 최종적인 로또 번호가 입력되어져야 한다.
 */
public class InputThreadTest1 {
	public static void main(String[] args) {
		//1. 데이터 입력 작업...
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요..."); 
		//와꾸 만드는 스윙기법? 스캐너는 콘솔로 출력하는데 이건 폼에다가 입력할 수 있도록 스윙기법으로 만든 것.
		System.out.println("입력하신 숫자는 "+input+" 입니다.");
		
		//2. 일종의 카운팅 작업...
		for(int i = 10; i > 0; i--) {
			try {
				Thread.sleep(600); // 0.6초
			}catch(InterruptedException e) {
				
			}
			System.out.println(i);
		}
	}

}
