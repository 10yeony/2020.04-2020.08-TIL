package thread.step6;
/*
 * MegaBoxUser�� MegaBox���� �¼��� �����ϴ� ���� �����ϴ� �������� ����..
 * reserve() ��� ����� �ϳ� �ۼ�... ���� ������ �ۼ�
 */
public class MegaBoxUser implements Runnable {
	private boolean seat = false; // �¼� ���Ű� ������ true �Ҵ�
	@Override
	public void run() {
		try {
			reserve();
		}
		catch(InterruptedException e) {
			
		}
	}
	
	public synchronized void reserve() throws InterruptedException { // run �޼ҵ尡 �ƴϹǷ� throw �� �� ����.
		// �����尡 �۾��ϰ� �ִ� ������ ����ȭ ó��
		String tName = Thread.currentThread().getName(); // ���� �������� �������� �̸��� �޾ƿ�.
		System.out.println(tName+"��, �����Ϸ� ���̽��ϴ�..!!");
		
		if(seat==false) {//�¼��� ����ٸ�..
			Thread.sleep(2000);
			System.out.println(tName+"��, �¼� ���� ����");
			seat = true;
		}else {//�¼��� �̹� �Ϸ�Ǿ��ٸ�...
			System.out.println(tName+"��, �ش� �¼��� �̹� ���� �Ϸ�� �¼��Դϴ�.");
		}
	}

}
