/*
 * 스레드를 만드는 방법
 * 1. extends Thread
 * 2. implements Runnable ---> 책에서는 이 방법을 더 추천. 상속은 다중상속이 불가능하므로!
 * 하지만 크게 상관 없다
 */
package thread.step2;
//Thread 클래스
public class GoThread implements Runnable {
	/*public GoThread(String name) {
		super(name); 
	}*/ // 부모가 인터페이스므로 부모 생성자 호출 불가능.

	@Override
	public void run() {
		int i = 0;
		while(true) { 
			try {
				Thread.sleep(1000); 
			}catch(InterruptedException e) {
				
			}
			String tname = Thread.currentThread().getName();
			System.out.println("CurrentThread :: "+tname+","+i);
			i++;
			if(i == 20) break;
		}
	}
}
