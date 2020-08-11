package self.test;

import java.util.Scanner;

public class PatternGameTest {

	public static void main(String[] args) {
		for (int run = 0;;) {
			System.out.println("10~99 사이의 정수를 입력하세요>>>");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			// % , / 연산자를 이용

			int start = n / 10;
			int end = n % 10;

			if (start == 3 || start == 6 || start == 9) { 
				// %3을 이용해서 구하면 십의 자리가 0일 경우까지 포함되므로 안 됨.
				if (end == 3 || end == 6 || end == 9) {
					System.out.println("@@");
					System.exit(0);
				} 
				else System.out.println("@");
			} 
			else if (end == 3 || end == 6 || end == 9) {
				System.out.println("@");
			} 
			else {
				System.out.println(n);
			}
		}

	}
}
