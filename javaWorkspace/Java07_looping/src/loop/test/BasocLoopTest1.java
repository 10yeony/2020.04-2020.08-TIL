package loop.test;
/*
 * 반복문
 * ::
 * 해당하는 조건이 참인 동안 코드 블록을 계속 수행하는 로직
 * for / while / do~while
 * 몇 개 있는지/돌리는 횟수를 알 때 for문을 쓰고 empty가 될 때까지 끝까지 돌릴 때 while문을 씀.
 * do~while은 한번은 무조건 돈다.
 */

public class BasocLoopTest1 {

	public static void main(String[] args) {
		System.out.println("=========== for ============");
		for(int i=0; i<=10; i++) {//
			System.out.println(i+".Hello..For Loop..");
		}
		
		System.out.println("=========== while ============");
		int i=10;
		while (i>0) {
			System.out.println(i+".Hello..For Loop..");
			i--;
		}
		
		System.out.println("===========do~while==========");
		int j=0;
		do {
			System.out.println(j+".Always Print..");
			j++; // 증감식
		}while(j<10);
	}

}
