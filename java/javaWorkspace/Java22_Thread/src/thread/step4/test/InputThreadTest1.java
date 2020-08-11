package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * ���ν����常 �����Ǵ� ����...
 * �����۾��� �ȵȴ�.
 * �ζǹ�ȣ�� �Է¹޴� �۾���
 * ī���� �۾��� ���������� ����Ǿ�� �Ѵ�.
 * ---------------------------
 * 10�� �ȿ� �������� �ζ� ��ȣ�� �ԷµǾ����� �Ѵ�.
 */
public class InputThreadTest1 {
	public static void main(String[] args) {
		//1. ������ �Է� �۾�...
		String input = JOptionPane.showInputDialog("���� �ζ� ��ȣ�� �Է��ϼ���..."); 
		//�Ͳ� ����� �������? ��ĳ�ʴ� �ַܼ� ����ϴµ� �̰� �����ٰ� �Է��� �� �ֵ��� ����������� ���� ��.
		System.out.println("�Է��Ͻ� ���ڴ� "+input+" �Դϴ�.");
		
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
