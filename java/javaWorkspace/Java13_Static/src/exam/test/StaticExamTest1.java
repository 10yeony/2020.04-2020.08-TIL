package exam.test;
/*
 * 1. static한 멤버는 객체 생성 없이 사용할 수 있다.
 */
class Member{
	static String name = "길똥이";
	static int age = 22; // static 변수, class 변수, 전역변수
	int count = 1; // 필드, 멤버 변수
	
	public static void getMember() { // static
		System.out.println("우/유/빛/깔/ "+name);
		// System.out.println("count :"+count); 
		// 에러남. static은 static끼리 통함. count는 static이 아니므로 아직 메모리에 없음.
	}
	public void getMember2() { // non-static
		System.out.println("우/유/빛/깔/ "+name);
	}
} 
public class StaticExamTest1 {

	public static void main(String[] args) {
		/*Member m = new Member(); // 객체 생성해야 쓸 수 있음.
		m.getMember();*/
		
		Member.getMember(); // static 쓰면 이 메소드가 어디있는지만 알려주면 바로 쓸 수 있음.
		
		/*// static은 static끼리 통한다.
		 * 메인은 미리 메모리에 올라가 있는 메소드. 그래서 스태틱끼리만 통하고 스태틱끼리는 객체 생성 안하고 접근 가능.
		Member.getMember2(); // static이 아니니까 메모리에 올려서 써야 함. 에러 남.*/
		Member m = new Member();
		m.getMember2(); // 이렇게 써야함.
		
		// static은 객체 생성 안 해줘도 돼서 편함.
		// 하지만 전부 다 static으로 하면 안 됨. static으로 지정된 애들이 메모리에 올라가는데 class area에 올라감. 
		// (반면 new로 만든 애들은 heap에 올라감)
		// 그래서 문제는 garbage collector의 대상이 아님. 청소는 heap만 함. 
		// 모든 걸 static으로 잡아두면 청소를 안 해주고 메모리 효율성이 급감함.
		// 메모리가 꽉 차고 영구적으로 안 지워짐. 그래서 static은 함부로 쓰면 안 된다.
	}

}
