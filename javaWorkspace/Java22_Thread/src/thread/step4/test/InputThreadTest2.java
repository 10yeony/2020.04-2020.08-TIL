package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * step2
 * ::
 * ī���� �۾��� ī���� �۾����
 * �˾�â �Է��� �˾�â �Է´��
 * ���������� �۾��� ����
 * ::
 * ���ν�����
 * �۾������� -- ī���� ó�� -- CountingThread(implements Runnable)
 */
class CountingThread implements Runnable{
	public void run() {
		//2. ������ ī���� �۾�...
		for(int i = 10; i > 0; i--) {
			try {
				Thread.sleep(600); // 0.6��
			}catch(InterruptedException e) {

			}
			System.out.println(i);
		}
	}
}

public class InputThreadTest2 {
	public static void main(String[] args) {
		CountingThread countT = new CountingThread();
		Thread t = new Thread(countT);
		
		t.start();
		
		//1. ������ �Է� �۾�...
		String input = JOptionPane.showInputDialog("���� �ζ� ��ȣ�� �Է��ϼ���..."); 
		System.out.println("�Է��Ͻ� ���ڴ� "+input+" �Դϴ�.");
		
	}

}