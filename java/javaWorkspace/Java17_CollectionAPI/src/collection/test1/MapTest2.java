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
public class MapTest2 {
	public static void main(String[] args) {
		// ��ü�� ������ �� �ִ�. int�� ������ �� ����. �׷��� int�� ���εǴ� Integer Ŭ���� Ÿ������ ����.
		Map<String, Integer> map = new HashMap<>();
		
		//add�� ���� Collection�� �ٸ�. put�� ��.
		// map.put("��ȣ��", new Integer(90)); ������ �̷��� ��� ��.
		map.put("��ȣ��", 90); // �ٵ� �̷��� �ᵵ �˾Ƽ� ȣȯ�ؼ� �������.
		map.put("�̼���", 100);
		map.put("�ǿ�", 90);
		map.put("����", 85);
		
		Set<String> key = map.keySet();
		
		// �̷��Ե� �� �� ������ ���� �̷��� ������ �ʰ� Iterator�� ���� ����.
		for(String name : key) {
			System.out.println(map.get(name));
		}
	}

}
