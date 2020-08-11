package fly.test;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;

public class FlyerTest {

	public static void main(String[] args) {
		// Flyer f1 = new Flyer(); 
		// ���ø�(�߻� �޼ҵ�)�� �ѹ���̶� �������� ��ü ������ �� �ȴ�!(������ �߿�)
		// ������ ������� ���赵�� �־�� �ϴµ� ���赵�� �ش��ϴ� �� Ŭ����!
		// Ŭ������ �Ϻ��� ���赵�̰� �Ϻ��� Ÿ��! �׷��� ��ü�� ��������� ��.
		// �������̽��� �Ϻ��� �߻��̾ ������ �ȵ�. �߻��� �����̶� ������ ��ü ������ �� ��.
		// = �߻��� �����̶� ������ �޸𸮿� �ö󰡴� ��󿡼� ������. �ҿ����� �͵��� �� �ö�.
		// ��ſ� Ÿ�����μ��� �ۿ���. Ÿ���� super��. 
		// ���赵�� �ҿ����ϸ� ��ǰ �� ����. ��ü ������ ���� �뵵�� �ƴϰ�, Ÿ�����μ��� ������.

		Flyer bird = new Bird(); // FlyerŸ������ Bird ��ü ���� ����.
		Flyer airplane = new AirPlane(); 
		Flyer superman = new SuperMan(); 
		// �̰� �ٷ� ������(Polymorphism). �θ� Ÿ������ �ڽ� ��ü�� ����� ��.
		
		//1.
		bird.fly(); 
		// �θ��� Ÿ������ ȣ���ϸ� �ڽ��� �޼ҵ尡 ����.
		// Virtual Method Invocation����... �������̵� �޼ҵ忡���� ��Ÿ��
		
		//2. bird.layEggs()�� �� ����. �θ� Ÿ�Կ��� ���� �޼ҵ��̹Ƿ� �ڽ� Ÿ������ �ҷ��� ��.
		String ret = ((Bird) bird).layEggs();
		System.out.println(ret);
	}

}
