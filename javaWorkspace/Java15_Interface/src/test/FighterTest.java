package test;

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		if(f instanceof Unit) {
			System.out.println("f는 Unit의 자손입니다..");
		}
		if(f instanceof Movable) {
			System.out.println("f는 Movable의 자손입니다.");
		}
		if(f instanceof Fightable) {
			System.out.println("f는 Fightable의 자손입니다.");
		}

	}

}

//클래스를 연달아서 만들 때는 public을 붙이면 안 됨.
class Unit{
	int currentHP; //유닛의 체력
	int x; // 유닛의 위치(x좌표) 
	int y; // 유닛의 위치(y좌표)
}

interface Movable{
	void move(int x, int y);
}

interface Attackable{
	void attck(Unit u);
}

// 인터페이스와 인터페이스 사이에는 implements 하면 안 됨. 그럼 구현해야 함.
// 인터페이스와 인터페이스 사이에는 구현이 아니라 상속임! extends를 써야 함.
// 인터페이스는 다중상속 가능. 인터페이스는 탬플릿 기능이지만 기능이 강화됨.
interface Fightable extends Movable, Attackable {
} //여기 사이에 뭐 써도 좋겠지만 아무것도 안 써도 도미.

class Fighter extends Unit implements Fightable{
// 클래스가 먼저 나와야 하고 클래스 상속이 먼저 일어나고 구현.
	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void attck(Unit u) {
		
	}
}