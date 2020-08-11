package exam.test;
// 지금 레벨에서는 쓸 일이 없을 것 같지만...
// 개념 이해한 사람은 개인 작업 때 써먹을 수 있음.
public class StaticExamTest3 {
	static int i;
	
	public static void main(String[] args) {
		// JVM이 메인 메소드를 제일 먼저 실행하고 메인보다 먼지 실행되는 곳은 없다.
		System.out.println("main method static block..."+i); // 이게 제일 먼저 실행되는 것.
		
		// 메인 밑에 객체 생성...객체 생성하면 돌아가는 알고리즘이 이것-> ();
		// 생성자 초기화. 생성자는 객체마다 초기화됨.
		// (); ---> (){ // } 
		
		// i는 스태틱 변수이므로 프린트에서 쓸 수 있음.
	}
	
	static {
		//원래 메인 메소드가 제일 먼저 실행되는데... 
		//그런데 메인보다 먼저 돌아가는 게 딱 하나 있는데 그게 바로 static initialization block.
		// 초기화도 급수가 있음. 글로벌한 초기화를 여기로 함. 
		// 일일이 다 초기화하는 건 각개전투. 글로벌한 뭔가가 쫙 초기화되어져 있는 것. 이런 건 생성자 초기화로 할 수 없음.
		// 웹에서는 이 개념이 굉장히 중요하다.
		i=300;
		System.out.println("1. static initialization block..."+i);
	}

}
