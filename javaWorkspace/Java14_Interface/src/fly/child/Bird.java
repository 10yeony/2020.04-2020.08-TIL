package fly.child;

import fly.Flyer;

/*
 * Flyer(�������̽�)�� ��ӹ��� �ڽ� Ŭ����..
 * �������̽��� �θ�� �� �ڽ��� (Bird) �ݵ�� �θ� ���� ��� �߻� �޼ҵ�(�����ΰ� ���� �޼ҵ�)�� �� �����ؾ߸� �Ѵ�.
 */
public class Bird implements Flyer{
	//Ŭ������ �޼ҵ�θ� ������ ���� ����(ex: Service)
	//Ŭ�������� �߻��� 1�� ����� ��. �׷��� �װɷκ��� instantiate�� ��(��ü ������ ��)
	//�θ�κ��� �������� ���� ����, �ڱ�ȭ, ��üȭ 
	// => �������̵�!(������ ����δ� �Ȱ���.)
	@Override
	public void fly() {
		System.out.println("���� ����...");
	}

	@Override
	public void land() {
		System.out.println("���� �����Ѵ�...");	
	}

	@Override
	public void take_off() {
		System.out.println("���� �̷��Ѵ�...");
	}
	
	public String layEggs() {
		return "���� ���";
	}
	
}