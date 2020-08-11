package thread.step4.test;

import javax.swing.JOptionPane;
/*
 * ī�����۾� - CountThread
 * �����Է��۾� - InputThread
 * ::
 * �� ������ ���� Communication�� ���μ����� �ڿ����� �ؾ� �Ѵ�.
 */
class CountThread extends Thread{
	private InputThreadTest3 process;
	public CountThread(InputThreadTest3 process) {
		this.process = process;
	}

	public void run() {
		//2. ������ ī���� �۾�...
		for(int i = 10; i > 0; i--) {
			if(process.inputCheck == true) break;
			System.out.println(i);
			try {
				Thread.sleep(600); // 0.6��
			}catch(InterruptedException e) {

			}
		}//for
		if(!process.inputCheck) {
			System.out.println("10�� ����Ǿ����ϴ�... �� �Է� �ð� �ʰ�!!!");
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
		//1. ������ �Է� �۾�...
		String input = JOptionPane.showInputDialog("���� �ζ� ��ȣ�� �Է��ϼ���..."); 
		System.out.println("�Է��Ͻ� ���ڴ� "+input+" �Դϴ�.");
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
		// ���μ����� ������ �������� ��. �ڿ� ������ ����. 
		// �ڿ��� ��¡�ϱ� ���ؼ�(�����尡 ���μ����� ����) 
		// �����尡 ���μ����� ������ ��� ��.
		
		countT.start();
		inputT.start();
		
	}

}
