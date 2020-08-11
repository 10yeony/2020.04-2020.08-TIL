package collection.test1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map
 * ::
 * key-value를 쌍으로 저장하는 특징을 가진다.
 */
public class MapTest2 {
	public static void main(String[] args) {
		// 객체만 저장할 수 있다. int는 저장할 수 없다. 그래서 int에 매핑되는 Integer 클래스 타입으로 저장.
		Map<String, Integer> map = new HashMap<>();
		
		//add를 쓰는 Collection과 다름. put을 씀.
		// map.put("강호동", new Integer(90)); 원래는 이렇게 써야 함.
		map.put("강호동", 90); // 근데 이렇게 써도 알아서 호환해서 만들어줌.
		map.put("이수근", 100);
		map.put("피오", 90);
		map.put("규현", 85);
		
		Set<String> key = map.keySet();
		
		// 이렇게도 할 수 있지만 보통 이렇게 뽑지는 않고 Iterator를 자주 쓴다.
		for(String name : key) {
			System.out.println(map.get(name));
		}
	}

}
