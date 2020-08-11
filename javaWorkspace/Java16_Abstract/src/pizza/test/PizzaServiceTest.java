package pizza.test;

import java.util.Vector;

import pizza.child.BulgogiPizza;
import pizza.child.PotatoPizza;
import pizza.child.ShrimpPizza;
import pizza.parent.Pizza;
import pizza.service.PizzaService;

public class PizzaServiceTest {
	public static void main(String[] args) {
		
		PizzaService service = new PizzaService();
		Vector<Pizza> v = new Vector<>();//10ĭ¥�� ���������.
		//Vector�� ��ü�� �����Ѵ�.
		//Vector<E> -> ���⼭ E�� Element�� ����. ��ҵ��� Ÿ���� ������ ��.
		//Vector�� �迭�� �Ȱ��� �����. Vector�� ������ �� �־ ��. 
		
		/* 
		v.add(e) -> ��ġ ���� ���ϰ� �׳� �� �������. �� �������� �ڵ����� ��.
		v.add(index, element); -> Ư���� ��ġ�� ���� ����.
		*/
		v.add(new PotatoPizza(12000, "Pizza Hut"));
		v.add(new BulgogiPizza(12000, "Domino Pizza"));
		v.add(new ShrimpPizza(12000, "�̽�������"));
		v.add(new BulgogiPizza(12000, "��������"));
		
		System.out.println("Vector �ȿ� ����� ������ �� : "+v.size()); // ����� �������� ����
		System.out.println("Vector�� Capacity : "+v.capacity()); // Vector�� �뷮. Vector�� ĭ�� : 10ĭ
		System.out.println("Pizza Information : "+v); // ��ü����... 
		// ������ vector�� ��ü �ּҰ��� ���;� �ϴµ� vector�� ��ü������ �������̵��� �Ǿ 
		// vector �ȿ� �ִ� ��ü���� ������ ����.
		// �׷��� Pizza Ŭ������ toString() ������ �ּҰ� ������ �� vector�� �ּҰ��� ������ �� �ƴ϶�
		// vector �ȿ� �ִ� ������ ��ü���� �ּҰ��� ���� �Ű� �׷��� ������ ��ü���� toString() ���� ��.
		
		/*
		v.remove(index); --> Ư���� ��ġ�� �ִ� �� ����
		v.remove(o); --> ���� ����
		*/
		
		//������ ���� �˰��� ����. �׷� �ֵ��� API ���� �ε��� ������ ����.
		
		service.allMakePizza(v);
	}

}
