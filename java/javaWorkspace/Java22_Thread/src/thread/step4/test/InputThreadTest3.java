package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * 카운팅작업 - CountThread
 * 숫자입력작업 - InputThread
 * ::
 * 두 스레드 간의 Communication은 프로세스의 자원으로 해야 한다.
 */
class CountThread extends Thread{
	private InputThreadTest3 process;
	public CountThread(InputThreadTest3 process) {
		this.process = process;
	}

	public void run() {
		//2. 일종의 카운팅 작업...
		for(int i = 10; i > 0; i--) {
			if(process.inputCheck == true) break;
			System.out.println(i);
			try {
				Thread.sleep(600); // 0.6초
			}catch(InterruptedException e) {

			}
		}//for
		if(!process.inputCheck) {
			System.out.println("10초 경과되었습니다... 값 입력 시간 초과!!!");
			System.exit(0);
		}
	}
}

class InputThread extends Thread{
	private InputThreadTest3 process;
	public InputThread(InputThreadTest3 process) {
		this.process = process;
	}
	
	public void run() {
		//1. 데이터 입력 작업...
		String input = JOptionPane.showInputDialog("최종 로또 번호를 입력하세요..."); 
		System.out.println("입력하신 숫자는 "+input+" 입니다.");
		process.inputCheck = true;
	}
}

// Process....
public class InputThreadTest3 {
	boolean inputCheck = false; 
	public static void main(String[] args) {
		InputThreadTest3 process = new InputThreadTest3();
		CountThread countT = new CountThread(process); 
		InputThread inputT = new InputThread(process);
		// 프로세스를 통으로 가져가게 함. 자원 공유를 위해. 
		// 자원을 해징하기 위해서(스레드가 프로세스를 가짐) 
		// 스레드가 프로세스를 가지고 놀게 함.
		
		countT.start();
		inputT.start();
		
	}

}
