package thread.step1;
//Thread Ŭ����
public class ComeThread extends Thread {
	public ComeThread(String name) {
		super(name); // ������ Ŭ���� ������ ȣ��.
	}
	
	// �����尡 �۵��ϴ� �κ�
	// ���� ȣ���ϴ� �� �ƴ϶� ���������� ȣ��Ǳ� ������ �״�� ��� ��.(����Ÿ�� ����x ���ڰ�x ����ó��x)
	public void run() { 
		int i = 0;
		while(true) {
			try {
				Thread.sleep(1000); // sleep�� static // 1�� ���� Ÿ��ĸ���� ����.
			// sleep�� ���� ó�� ����� �ϴµ� run �޼ҵ� �ڿ� throw �� ����. ���������� ȣ��Ǵ� �޼ҵ��.
			}catch(InterruptedException e) {
				
			}
			String tname = Thread.currentThread().getName();
			System.out.println("CurrentThread :: "+tname+","+i);
			i++;
			if(i == 20) break;
		}
		
	}
}
