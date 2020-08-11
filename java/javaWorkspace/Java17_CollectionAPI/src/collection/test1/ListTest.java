package collection.test1;

import java.util.ArrayList;
import java.util.List;

/*
 * List�� �����Ͱ� ����Ǵ� Ư¡
 * 1) �ߺ� ���
 * 2) ������ �ִ�
 * Vector �Ⱦ�. LinkedList�� �� ��. ArrayList�� �� ����.
 */
public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(); // �θ�Ÿ������ �ڽ�Ŭ���� ����=Polymorphism
		// Ŭ���� List�� �ƴ϶� �������̽��� List. Ŭ���� List�� GUI�� List��.
		list.add("��ȣ��");
		list.add("�̼���");
		list.add("����");
		list.add("�ǿ�");
		list.add("�̼���");
		
		System.out.println(list); 
		// Collection���� list.toString�� �ڵ����� �Ǿ �ȿ� �ִ� �������� ������ ��µ�.
		// ���⼭�� list�� �ּҰ��� ������ �� �ƴ�.
		
		// �̼��� �ߺ� ����.
		// ���� ������� ����. ordered.
		// ��ȣ��, ����, �̼���, �̼���, �ǿ� -> �̷��� ������ �� ����. 
		// ������ TreeSet. Tree�� ���� �� ����!
		// ordered�� ������� ���� ����.
		// ������ ������ ������ �ٸ� �����̴�!!
	}

}
