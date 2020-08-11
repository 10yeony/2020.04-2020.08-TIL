/*
 * �����带 ����� ���
 * 1. extends Thread
 * 2. implements Runnable ---> å������ �� ����� �� ��õ. ����� ���߻���� �Ұ����ϹǷ�!
 * ������ ũ�� ��� ����
 */
package thread.step2;
//Thread Ŭ����
public class GoThread implements Runnable {
	/*public GoThread(String name) {
		super(name); 
	}*/ // �θ� �������̽��Ƿ� �θ� ������ ȣ�� �Ұ���.

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
