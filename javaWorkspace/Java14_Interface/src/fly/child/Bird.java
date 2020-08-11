package fly.child;

import fly.Flyer;

/*
 * Flyer(인터페이스)를 상속받은 자식 클래스..
 * 인터페이스를 부모로 둔 자식은 (Bird) 반드시 부모가 가진 모든 추상 메소드(구현부가 없는 메소드)를 다 구현해야만 한다.
 */
public class Bird implements Flyer{
	//클래스에 메소드로만 구성될 수는 있음(ex: Service)
	//클래스에는 추상이 1도 없어야 함. 그래야 그걸로부터 instantiate가 됨(객체 생성이 됨)
	//부모로부터 물려받은 것을 구현, 자기화, 구체화 
	// => 오버라이딩!(물려준 선언부는 똑같음.)
	@Override
	public void fly() {
		System.out.println("새가 난다...");
	}

	@Override
	public void land() {
		System.out.println("새가 착륙한다...");	
	}

	@Override
	public void take_off() {
		System.out.println("새가 이륙한다...");
	}
	
	public String layEggs() {
		return "알을 까다";
	}
	
}