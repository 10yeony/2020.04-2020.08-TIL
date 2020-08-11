package exam.test;
//필드와 static 변수가 어떻게 다른지를 확실하게 구분...
//static 변수는 생성된 객체들이 값을 공유한다...!!! 의미를 정확하게 이해.
// 객체가 아무리 많이 만들어져도 static 변수는 함께 공유함.
// 객체마다 변하는 값(이름, 나이, 주소)은 필드로 잡고, 
// 서로 다른 객체들이 공유해야 하는 값은 static으로 잡아야 함. 
// static은 변하는 게 아니라 항상 같은 값을 써야 함. 따라서 상수로 씀.

// 카드가 있으면 문양(다이아,하트,클로버..), 카드넘버는 다 다르게 필드로 잡아주지만
// width, height, 총 개수는 공통적인 것이므로 공유하고 따라서 static 변수로 잡는다.

class Car{
	// serialNumber랑 counter는 선언된 위치가 필드 레벨.
	// static한 변수는 로컬 레벨에 못 씀.
	int serialNumber;
	static int counter; 
	// static한 변수는 클래스의 식구가 아님. 따라서 필드가 아님.
	// 그냥 범용적인 global한 애임.
	
	Car(){//생성자
		counter++;//1
		serialNumber = counter;
	}
	
}

public class StaticExamTest2 {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("========= field ============");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("\n=======Static V==========");
		System.out.println(Car.counter);
		System.out.println(car1.counter); 
		System.out.println(car2.counter);
		System.out.println(car3.counter);
		// System.out.println(car4.counter); // 위에꺼는 객체 생성해서 참조변수로 쓸 수 있는 것.

	}

}
