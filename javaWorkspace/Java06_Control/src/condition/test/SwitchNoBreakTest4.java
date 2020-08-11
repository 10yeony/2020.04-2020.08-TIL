package condition.test;

/*
 * Math.random()와 함께
 * switch문에서의 break 키워드에 대해서 살펴보자.
 */
public class SwitchNoBreakTest4 {
	public static void main(String[] args) {

		/*
		 * int d=(int)(Math.random()*4)+1; // 캐스팅이라는 것. int값만 받아볼 때 이렇게 씀. //
		 * Math.random()은 0~1사이의 랜덤한 실수를 랜덤으로 뽑아냄. 여기서는 1~4 사이의 랜덤한 정수를 뽑아냄. // Math는
		 * 라이브러리 클래스. Math에서 제공하는 모든 기능들은 Math.까지 쳤을 때 뜨는 아이콘에서 s가 보임. //static한 성질. s가
		 * 붙은 애들은 미리 메모리에 올려놓은 애들=객체 생성 과정 안 해도 쓸 수 있음.
		 */

		// 8~11 사이의 랜덤한 정수
		int time = (int) (Math.random() * 4) + 8;
		System.out.println("[현재시간: " + time + " 시]");

		switch (time) {
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("오전회의 합니다.");
		case 10:
			System.out.println("오전 업무 봅니다.");
		case 11:
			System.out.println("외근 나갑니다.");
		}

	}

}
