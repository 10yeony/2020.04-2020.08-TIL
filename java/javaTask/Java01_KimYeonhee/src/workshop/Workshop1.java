package workshop;

public class Workshop1 {

	public static void main(String[] args) {
		System.out.println("���� 1)");
		
		int [][] stair = 
			{{1,2,3,4,5},
				{6,7,8,9},
				{10,11,12},
				{13,14},
				{15}};
		// ��� ������� ȭ�鿡 ��µ� 2���� �迭
		
		/* �׽�Ʈ 2���� �迭
		int [][] stair = 
			{{1,2,3,4,5,6},
				{7,8,9,10,11},
				{12,13,14,15},
				{16,17,18},
				{19,20},
				{21}};
		*/
		
		for(int i = 0; i < stair.length; i++) {
			for(int n = 0; n < i; n++) System.out.print("   "); // ���ʿ� ��µ� ����
			for(int j = 0; j < stair[i].length; j++) {
				System.out.print(stair[i][j] + " "); // ���� + ���� ���
				if(stair[i][j] < 10) System.out.print(" ");
				// ���ڸ����� ��� �ڿ� ������ �� �ٿ� ���ڸ����� ĭ ũ�⸦ ����
			}
			System.out.print("\n"); // �ٹٲ�
		}
	
		System.out.println("\n\n���� 2)");
		
		int[][] sandglass = 
			{ {1,2,3,4,5}, 
				{6,7,8}, 
				{9}, 
				{10,11,12}, 
				{13,14,15,16,17} }; 
		// �𷡽ð� ������� ȭ�鿡 ��µ� 2���� �迭
		
		/* �׽�Ʈ 2���� �迭 
		int[][] sandglass = 
	         { {1,2,3,4,5,6,7}, 
				{8,9,10,11,12}, 
				{13,14,15}, 
				{16}, 
				{17,18,19}, 
				{20,21,22,23,24}, 
				{25,26,27,28,29,30,31} };
		*/
		
		int allLine = sandglass.length; // ��ü ��
		int cenLine = allLine / 2 + 1; // ��� ��(center line)
		int curLine = 1; // ���� ��(current line)
		
		for (int i = 0; i < allLine; i++) {
			int blank = cenLine-Math.abs(cenLine-curLine)-1; // ���� ����
			for(int n = 0; n < blank; n++) System.out.print("   "); // ���ʿ� ��µ� ����
			for (int j = 0; j < sandglass[i].length; j++) {
				System.out.print(sandglass[i][j] + " "); // ���� + ���� ���
				if (sandglass[i][j] < 10) System.out.print(" ");
				// ���ڸ����� ��� �ڿ� ������ �� �ٿ� ���ڸ����� ĭ ũ�⸦ ����
			}
			for(int n = 0; n < blank; n++) System.out.print("   "); // �����ʿ� ��µ� ����
			System.out.print("\n"); // �ٹٲ�
			curLine++;
		}
	}
}
