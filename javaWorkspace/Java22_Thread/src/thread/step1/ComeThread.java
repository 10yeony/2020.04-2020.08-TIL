package thread.step1;
//Thread 클래스
public class ComeThread extends Thread {
	public ComeThread(String name) {
		super(name); // 스레드 클래스 생성자 호출.
	}
	
	// 스레드가 작동하는 부분
	// 내가 호출하는 게 아니라 내부적으로 호출되기 때문에 그대로 써야 함.(리턴타입 변경x 인자값x 예외처리x)
	public void run() { 
		int i = 0;
		while(true) {
			try {
				Thread.sleep(1000); // sleep는 static // 1초 동안 타임캡슐에 있음.
			// sleep는 예외 처리 해줘야 하는데 run 메소드 뒤에 throw 못 붙임. 내부적으로 호출되는 메소드라서.
			}catch(InterruptedException e) {
				
			}
			String tname = Thread.currentThread().getName();
			System.out.println("CurrentThread :: "+tname+","+i);
			i++;
			if(i == 20) break;
		}
		
	}
}
