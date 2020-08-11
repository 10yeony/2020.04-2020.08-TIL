package collection.test1;

import java.util.HashSet;
import java.util.Set;

/*
 * Set
 * ::
 * Ű���� : Unique
 * �ߺ��ȵ� / ��������
 */
public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>(); 
		// Set�� �������̽��Ƿ� ��ü ����X. Ŭ���� HashSet���� ����.
		set.add("��ȣ��");
		set.add("�̼���");
		set.add("����");
		set.add("�ǿ�");
		set.add("�̼���");
		
		System.out.println(set);
		System.out.println(set.size()); 
		boolean find=set.contains("������");
		System.out.println(find); //false
		
		set.remove("����");
		System.out.println(set);
		
		set.clear(); // removeAll()�� ����.
		System.out.println("�������?"+set.isEmpty()); // true
		System.out.println(set);

	}

}
