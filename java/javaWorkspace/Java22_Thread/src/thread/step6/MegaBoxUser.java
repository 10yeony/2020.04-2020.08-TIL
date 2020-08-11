package thread.step6;
/*
 * MegaBoxUser는 MegaBox에서 좌석을 예매하는 일을 전담하는 스레드라고 간주..
 * reserve() 라는 기능을 하나 작성... 예매 로직을 작성
 */
public class MegaBoxUser implements Runnable {
	private boolean seat = false; // 좌석 예매가 끝나면 true 할당
	@Override
	public void run() {
		try {
			reserve();
		}
		catch(InterruptedException e) {
			
		}
	}
	
	public synchronized void reserve() throws InterruptedException { // run 메소드가 아니므로 throw 할 수 있음.
		// 스레드가 작업하고 있는 영역에 동기화 처리
		String tName = Thread.currentThread().getName(); // 현재 실행중인 스레드의 이름을 받아옴.
		System.out.println(tName+"님, 예매하러 오셨습니다..!!");
		
		if(seat==false) {//좌석이 비었다면..
			Thread.sleep(2000);
			System.out.println(tName+"님, 좌석 예매 성공");
			seat = true;
		}else {//좌석이 이미 완료되었다면...
			System.out.println(tName+"님, 해당 좌석은 이미 예매 완료된 좌석입니다.");
		}
	}

}
