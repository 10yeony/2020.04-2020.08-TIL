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
 * key-value�� ������ �����ϴ� Ư¡�� ������.
 */
public class MapTest {
	public static void main(String[] args) {
		// ��ü�� ������ �� �ִ�. int�� ������ �� ����. �׷��� int�� ���εǴ� Integer Ŭ���� Ÿ������ ����.
		Map<String, Integer> map = new HashMap<>();
		
		//add�� ���� Collection�� �ٸ�. put�� ��.
		// map.put("��ȣ��", new Integer(90)); ������ �̷��� ��� ��.
		map.put("��ȣ��", 90); // �ٵ� �̷��� �ᵵ �˾Ƽ� ȣȯ�ؼ� �������.
		map.put("�̼���", 100);
		map.put("�ǿ�", 90);
		map.put("����", 85);
		
		System.out.println(map);
		
		//1. Ű�� �޾ƿ´�..keySet()
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator(); // Iterator �������̽��� Collection�� �ִ� �͵��� �̾ƿ�.
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name+" ====    "+map.get(name));
		}
		
		//2. Ű�� �ش��ϴ� value�� ã�Ƽ� ���
		Collection<Integer> col = map.values(); // 90, 100, 90, 85�� ����.
		int total = 0;
		
		Iterator<Integer> it2 = col.iterator();
		while(it2.hasNext()) {
			total += it2.next();
		}
		
		//3. 
		System.out.println("��� : "+total/map.size());
		System.out.println("�ְ����� : "+Collections.max(col));
		System.out.println("�������� : "+Collections.min(col));
		
		// map.containsKey(key) -> ��ǥ ����!!! List, Set���� Map�� ���� ���õ�.
		
		
	}

}
