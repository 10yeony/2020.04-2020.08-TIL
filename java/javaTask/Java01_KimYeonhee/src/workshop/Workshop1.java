package workshop;

public class Workshop1 {

	public static void main(String[] args) {
		System.out.println("문제 1)");
		
		int [][] stair = 
			{{1,2,3,4,5},
				{6,7,8,9},
				{10,11,12},
				{13,14},
				{15}};
		// 계단 모양으로 화면에 출력될 2차원 배열
		
		/* 테스트 2차원 배열
		int [][] stair = 
			{{1,2,3,4,5,6},
				{7,8,9,10,11},
				{12,13,14,15},
				{16,17,18},
				{19,20},
				{21}};
		*/
		
		for(int i = 0; i < stair.length; i++) {
			for(int n = 0; n < i; n++) System.out.print("   "); // 왼쪽에 출력될 공백
			for(int j = 0; j < stair[i].length; j++) {
				System.out.print(stair[i][j] + " "); // 숫자 + 공백 출력
				if(stair[i][j] < 10) System.out.print(" ");
				// 한자리수일 경우 뒤에 공백을 더 붙여 두자리수와 칸 크기를 맞춤
			}
			System.out.print("\n"); // 줄바꿈
		}
	
		System.out.println("\n\n문제 2)");
		
		int[][] sandglass = 
			{ {1,2,3,4,5}, 
				{6,7,8}, 
				{9}, 
				{10,11,12}, 
				{13,14,15,16,17} }; 
		// 모래시계 모양으로 화면에 출력될 2차원 배열
		
		/* 테스트 2차원 배열 
		int[][] sandglass = 
	         { {1,2,3,4,5,6,7}, 
				{8,9,10,11,12}, 
				{13,14,15}, 
				{16}, 
				{17,18,19}, 
				{20,21,22,23,24}, 
				{25,26,27,28,29,30,31} };
		*/
		
		int allLine = sandglass.length; // 전체 줄
		int cenLine = allLine / 2 + 1; // 가운데 줄(center line)
		int curLine = 1; // 현재 줄(current line)
		
		for (int i = 0; i < allLine; i++) {
			int blank = cenLine-Math.abs(cenLine-curLine)-1; // 공백 개수
			for(int n = 0; n < blank; n++) System.out.print("   "); // 왼쪽에 출력될 공백
			for (int j = 0; j < sandglass[i].length; j++) {
				System.out.print(sandglass[i][j] + " "); // 숫자 + 공백 출력
				if (sandglass[i][j] < 10) System.out.print(" ");
				// 한자리수일 경우 뒤에 공백을 더 붙여 두자리수와 칸 크기를 맞춤
			}
			for(int n = 0; n < blank; n++) System.out.print("   "); // 오른쪽에 출력될 공백
			System.out.print("\n"); // 줄바꿈
			curLine++;
		}
	}
}
