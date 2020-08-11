package fly;
// 완벽한 추상화... 구현된 것이 하나도 없어야 인터페이스이다.
// 인터페이스 구성요소 = 추상 메소드 + 상수
public interface Flyer {
	public static final int SIZE = 100; // 인터페이스는 필드가 없지만 상수는 있을 수 있다.
	// 날으는 것과 관련된 기능의 Template을 선언...
	public abstract void fly();
	public void land(); // 무조건 앞에 public abstract가 생략된다.
	void take_off(); // 빼고 쓰는 게 편함.
}
