package fly.child;

import fly.Flyer;

public class SuperMan implements Flyer {
	@Override
	public void fly() {
		System.out.println("���۸� ����...");
		System.out.println("�ü� : "+SIZE+"km...");
	}

	@Override
	public void land() {
		System.out.println("���۸� land...");	
	}

	@Override
	public void take_off() {
		System.out.println("���۸� take_off...");
	}
	
	public String StopBullet() {
		return "���� ���Ѵ�";
	}
}
