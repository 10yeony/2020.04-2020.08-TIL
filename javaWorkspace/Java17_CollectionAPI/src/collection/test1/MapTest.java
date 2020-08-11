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
public class MapTest {
	public static void main(String[] args) {
		// 객체만 저장할 수 있다. int는 저장할 수 없다. 그래서 int에 매핑되는 Integer 클래스 타입으로 저장.
		Map<String, Integer> map = new HashMap<>();
		
		//add를 쓰는 Collection과 다름. put을 씀.
		// map.put("강호동", new Integer(90)); 원래는 이렇게 써야 함.
		map.put("강호동", 90); // 근데 이렇게 써도 알아서 호환해서 만들어줌.
		map.put("이수근", 100);
		map.put("피오", 90);
		map.put("규현", 85);
		
		System.out.println(map);
		
		//1. 키만 받아온다..keySet()
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator(); // Iterator 인터페이스는 Collection에 있는 것들을 뽑아옴.
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name+" ====    "+map.get(name));
		}
		
		//2. 키에 해당하는 value를 찾아서 출력
		Collection<Integer> col = map.values(); // 90, 100, 90, 85가 저장.
		int total = 0;
		
		Iterator<Integer> it2 = col.iterator();
		while(it2.hasNext()) {
			total += it2.next();
		}
		
		//3. 
		System.out.println("평균 : "+total/map.size());
		System.out.println("최고점수 : "+Collections.max(col));
		System.out.println("최저점수 : "+Collections.min(col));
		
		// map.containsKey(key) -> 별표 세개!!! List, Set보다 Map이 가장 세련됨.
		
		
	}

}
