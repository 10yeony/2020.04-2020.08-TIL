package test;

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		if(f instanceof Unit) {
			System.out.println("f�� Unit�� �ڼ��Դϴ�..");
		}
		if(f instanceof Movable) {
			System.out.println("f�� Movable�� �ڼ��Դϴ�.");
		}
		if(f instanceof Fightable) {
			System.out.println("f�� Fightable�� �ڼ��Դϴ�.");
		}

	}

}

//Ŭ������ ���޾Ƽ� ���� ���� public�� ���̸� �� ��.
class Unit{
	int currentHP; //������ ü��
	int x; // ������ ��ġ(x��ǥ) 
	int y; // ������ ��ġ(y��ǥ)
}

interface Movable{
	void move(int x, int y);
}

interface Attackable{
	void attck(Unit u);
}

// �������̽��� �������̽� ���̿��� implements �ϸ� �� ��. �׷� �����ؾ� ��.
// �������̽��� �������̽� ���̿��� ������ �ƴ϶� �����! extends�� ��� ��.
// �������̽��� ���߻�� ����. �������̽��� ���ø� ��������� ����� ��ȭ��.
interface Fightable extends Movable, Attackable {
} //���� ���̿� �� �ᵵ �������� �ƹ��͵� �� �ᵵ ����.

class Fighter extends Unit implements Fightable{
// Ŭ������ ���� ���;� �ϰ� Ŭ���� ����� ���� �Ͼ�� ����.
	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void attck(Unit u) {
		
	}
}