/*
 * BeepPrintTest1 ����Ŭ����... �ϳ��� ���μ���
 * �� �ȿ��� ���ν����� �ϳ��ۿ� ������...
 * ���� �۾��� �Ұ����ߴ�.
 * 
 * ---------------------------------
 * BeepPrintTest2 ����Ŭ����..... �ϳ��� ���μ���
 * �� �ȿ� ���ν����� + �۾������� �ϳ� �� �߰�
 * 1) ���� ������ : beep()�� 5�� ---- ����� 5�� 	�߻� 
 * 2) �۾� ������ : BeepPrintThread ---- ���� 5�� ���
 * 
 */
package thread.step3.test;

import java.awt.Toolkit;

class BeepPrintThread extends Thread{
	public void run() {
	// �������� 5�� ����ϴ� �۾�
		for(int i = 0; i < 5; i++) {
			System.out.println("��~~~");
			try {
				Thread.sleep(500); // 0.5�ʷ� ���.
			} catch (InterruptedException e) {

			}
		}
	}
}

public class BeepPrintTest2 {
	public static void main(String[] args) {
		BeepPrintThread beepT = new BeepPrintThread();
		beepT.start(); // ���⸦ �������� �ϳ��� ���� run()�� �����ϰ� �ϳ��� ���� ������.
		// start�� �������� �۾��� ����Ǵ� ����.
		
		Toolkit tool = Toolkit.getDefaultToolkit(); // static��.
		// �溸�� 5�� �︮�� �۾�
		for(int i = 0; i < 5; i++) {
			tool.beep(); //�溸���� �����. �ٵ� �̰͸� ���� �ʹ� ���� �������� 5������ �� �鸮�� 1������ �鸲.
			
			try {
				Thread.sleep(500); // 0.5�ʷ� ���.
			} catch (InterruptedException e) {
				
			}
		}
	}

}

// ������� �߻���Ű�� / ���ÿ� ������� �ַܼ� �������ϴ� �۾� ==> ���⼭�� �Ұ���.
