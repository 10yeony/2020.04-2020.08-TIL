package thread.step6.test;

import thread.step6.MegaBoxUser;

public class MegaBoxUserProcess {
// ���μ����� ������ �ϳ��� �ݵ�� �����µ� �װ� �ٷ� ���ν�����(���󽺷���)
	public static void main(String[] args) {
		MegaBoxUser user = new MegaBoxUser();
		Thread t1 = new Thread(user, "�ӿ���");
		Thread t2 = new Thread(user, "ȿ��");
		
		t1.start();
		t2.start();
	}

}
