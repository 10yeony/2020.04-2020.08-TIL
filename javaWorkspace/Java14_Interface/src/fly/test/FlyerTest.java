package fly.test;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.SuperMan;

public class FlyerTest {

	public static void main(String[] args) {
		// Flyer f1 = new Flyer(); 
		// 템플릿(추상 메소드)이 한방울이라도 들어가있으면 객체 생성이 안 된다!(굉장히 중요)
		// 뭔가를 만들려면 설계도가 있어야 하는데 설계도에 해당하는 게 클래스!
		// 클래스는 완벽한 설계도이고 완벽한 타입! 그래야 객체가 만들어지는 것.
		// 인터페이스는 완벽한 추상이어서 더더욱 안됨. 추상이 조금이라도 있으면 객체 생성이 안 됨.
		// = 추상이 조금이라도 있으면 메모리에 올라가는 대상에서 제껴짐. 불완전한 것들은 못 올라감.
		// 대신에 타입으로서는 작용함. 타입은 super급. 
		// 설계도가 불완전하면 제품 못 만듦. 객체 생성을 위한 용도가 아니고, 타입으로서만 존재함.

		Flyer bird = new Bird(); // Flyer타입으로 Bird 객체 생성 가능.
		Flyer airplane = new AirPlane(); 
		Flyer superman = new SuperMan(); 
		// 이게 바로 다형성(Polymorphism). 부모 타입으로 자식 객체를 만드는 것.
		
		//1.
		bird.fly(); 
		// 부모의 타입으로 호출하면 자식의 메소드가 나옴.
		// Virtual Method Invocation원리... 오버라이딩 메소드에서만 나타남
		
		//2. bird.layEggs()는 안 나옴. 부모 타입에는 없는 메소드이므로 자식 타입으로 불러야 함.
		String ret = ((Bird) bird).layEggs();
		System.out.println(ret);
	}

}
