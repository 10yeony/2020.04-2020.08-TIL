/*
 * �ش� �ڵ忡���� ������ �����带 �ۼ����� �ʰ� ����....
 * ������� �߻���Ű�� / ���ÿ� ������� �ַܼ� �������ϴ� �۾� ==> �̷� �۾��� �������� �۾��̶�� ��.
 * �� ���� ���� main �Ʒ����� ó���ϵ��� �� ���̴�.
 */
package thread.step3.test;

import java.awt.Toolkit;

public class BeepPrintTest1 {
	public static void main(String[] args) {
		Toolkit tool = Toolkit.getDefaultToolkit(); // static��.
		// �溸�� 5�� �︮�� �۾�
		for(int i = 0; i < 5; i++) {
			tool.beep(); //�溸���� �����. �ٵ� �̰͸� ���� �ʹ� ���� �������� 5������ �� �鸮�� 1������ �鸲.
			try {
				Thread.sleep(500); // 0.5�ʷ� ���.
			} catch (InterruptedException e) {
				
			}
		}
		
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
// ������� �߻���Ű�� / ���ÿ� ������� �ַܼ� �������ϴ� �۾� ==> ���⼭�� �Ұ���.
