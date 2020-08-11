package collection.test1;

import java.util.HashSet;
import java.util.Set;

/*
 * Set
 * ::
 * 키워드 : Unique
 * 중복안됨 / 순서없음
 */
public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>(); 
		// Set은 인터페이스므로 객체 생성X. 클래스 HashSet으로 만듦.
		set.add("강호동");
		set.add("이수근");
		set.add("규현");
		set.add("피오");
		set.add("이수근");
		
		System.out.println(set);
		System.out.println(set.size()); 
		boolean find=set.contains("김혜수");
		System.out.println(find); //false
		
		set.remove("규현");
		System.out.println(set);
		
		set.clear(); // removeAll()과 같다.
		System.out.println("비었나요?"+set.isEmpty()); // true
		System.out.println(set);

	}

}
