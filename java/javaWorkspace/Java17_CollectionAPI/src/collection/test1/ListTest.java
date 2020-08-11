package collection.test1;

import java.util.ArrayList;
import java.util.List;

/*
 * List에 데이터가 저장되는 특징
 * 1) 중복 허용
 * 2) 순서도 있다
 * Vector 안씀. LinkedList도 안 씀. ArrayList를 쓸 것임.
 */
public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(); // 부모타입으로 자식클래스 생성=Polymorphism
		// 클래스 List가 아니라 인터페이스의 List. 클래스 List는 GUI의 List임.
		list.add("강호동");
		list.add("이수근");
		list.add("규현");
		list.add("피오");
		list.add("이수근");
		
		System.out.println(list); 
		// Collection들은 list.toString이 자동으로 되어서 안에 있는 데이터의 내용이 출력됨.
		// 여기서도 list의 주소값이 나오는 게 아님.
		
		// 이수근 중복 가능.
		// 넣은 순서대로 나옴. ordered.
		// 강호동, 규현, 이수근, 이수근, 피오 -> 이렇게 나오는 건 정렬. 
		// 정렬은 TreeSet. Tree가 붙은 게 정렬!
		// ordered는 넣은대로 나온 거임.
		// 순서와 정렬은 완전히 다른 개념이다!!
	}

}
