package exam.test;
/*
 * Singletone Pattern
 * ::
 * 클래스로부터 오직 단 한개의 인스턴스만 생성하고
 * 외부로부터 객체 생성을 하지 못하도록 막아두는 패턴.
 * 
 * 코드 작성 방법 1->2->3
 * 1. 클래스에서 일단 하나의 객체를 생성 --- private static 으로 지정해서 생성 
 * 2. 외부에서 객체생성을 못하도록 막는다 --- private 생성자() // 생성자 앞에 private를 붙이면 된다.
 * 3. 하나 만들어놓은 객체를 외부에서 사용할 수 있도록 미리 메모리에 올려놓고 열어둔다 --- public static 으로 지정
 * 
 */

class Factory{
	private static Factory factory = new Factory(); //1
	private Factory() { //2
		System.out.println("Car Factory.... Creating.....");
	}
	public static Factory getInstance() { //3
		return factory;
	}
}

public class StaticExamTest5 {
	
	public static void main(String[] args) {
		// Factory f = new Factory(); 못 만듦. 에러 남.
		// 에러 나는 이유? 객체를 생성할 때마다 호출되는 게 생성자인데 생성자 호출을 private로 막아둠.
		// 객체 생성 못하는데 접근해야 하는데.. 못 받아쓰는 상황...
		// 그래서 반드시 public static을 써야 함.
		// public static Factory getInstance()
		// 그런데 public Factory getInstance()라고 써서 못 쓰는 실수를 엄청 많이 함.
		Factory factory1 = Factory.getInstance(); 
		Factory factory2 = Factory.getInstance();
		Factory factory3 = Factory.getInstance();
		System.out.println(factory1);
		System.out.println(factory2);
		System.out.println(factory3);
		// 주소값 찍어보면 다 같은 주소값 나오면 다 똑같은 객체 factory가 리턴된 것.
	}

}
