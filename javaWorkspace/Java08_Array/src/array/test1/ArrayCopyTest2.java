package array.test1;
/*
 * 배열은 사이즈를 수정할 순 없지만
 * 사이즈가 다른 배열의 요소를 copy 떠서 가져올 수는 있다.
 */

public class ArrayCopyTest2 {

	public static void main(String[] args) {
		int [ ] target = {1,2,3,4,5,6};
		int [ ] source = {10,9,8,7,6,5,4,3,2,1};
		
		System.arraycopy(source, 2, target, 1, 3);
		// 배열 source에서 복사해올 건데 2번째 인덱스부터 복사할 것이다.
		// 그리고 그걸 배열 target에 붙여넣기 할 건데 1번째 인덱스부터 붙여넣을 것이며 연달아서 3개를 붙여넣을 것이다. 
		// 이렇게 되면 배열 target에서 -> 0,4,5번째 인덱스는 그대로임.
		for(int i : target) System.out.print(i + " ");
		//1 8 7 6 5 6  출력
	}
}
