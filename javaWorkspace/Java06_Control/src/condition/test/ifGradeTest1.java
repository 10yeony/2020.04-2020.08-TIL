package condition.test;

import java.util.Scanner;

/*
 * 제어문이란?
 * 주어진 조건이 참일 때만 해당 코드 블록을 수행함.
 * 문장의 흐름을 제어함으로써 좀 더 정교한 프로그램이 만들어질 수 있다.
 * ::
 * if(boolean expression) / else if(boolean expression) / else
 * switch~case
 */
public class ifGradeTest1 {
	public static void main(String[] args) {
		//성적에 따른 Grade를 제어하는 문장을 작성...
		int grade = 87;
		if(grade>=90 && grade<=100) System.out.println("A Grade...");
		else if(grade>=80 && grade<90) System.out.println("B Grade...");
		else if(grade>=70 && grade<80) System.out.println("C Grade...");
		else if(grade>=0 && grade<70) System.out.println("D Grade...");
		else System.out.println("Try again..."); // 코드가 한줄일 경우 {} 생략 가능
		
	}

}
