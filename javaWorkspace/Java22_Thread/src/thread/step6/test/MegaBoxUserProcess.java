package thread.step6.test;

import thread.step6.MegaBoxUser;

public class MegaBoxUserProcess {
// 프로세스는 스레드 하나는 반드시 가지는데 그게 바로 메인스레드(데몬스레드)
	public static void main(String[] args) {
		MegaBoxUser user = new MegaBoxUser();
		Thread t1 = new Thread(user, "임영웅");
		Thread t2 = new Thread(user, "효정");
		
		t1.start();
		t2.start();
	}

}
