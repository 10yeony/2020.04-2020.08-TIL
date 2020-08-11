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
		Vector<Pizza> v = new Vector<>();//10칸짜리 만들어진다.
		//Vector는 객체만 저장한다.
		//Vector<E> -> 여기서 E는 Element의 약자. 요소들의 타입을 적으면 됨.
		//Vector는 배열과 똑같이 생겼다. Vector는 사이즈 안 넣어도 됨. 
		
		/* 
		v.add(e) -> 위치 지정 안하고 그냥 값 집어넣음. 맨 마지막에 자동으로 들어감.
		v.add(index, element); -> 특정한 위치에 값을 넣음.
		*/
		v.add(new PotatoPizza(12000, "Pizza Hut"));
		v.add(new BulgogiPizza(12000, "Domino Pizza"));
		v.add(new ShrimpPizza(12000, "미스터피자"));
		v.add(new BulgogiPizza(12000, "오구피자"));
		
		System.out.println("Vector 안에 저장된 피자의 수 : "+v.size()); // 저장된 데이터의 갯수
		System.out.println("Vector의 Capacity : "+v.capacity()); // Vector의 용량. Vector의 칸수 : 10칸
		System.out.println("Pizza Information : "+v); // 객체정보... 
		// 원래는 vector의 전체 주소값이 나와야 하는데 vector는 자체적으로 오버라이딩이 되어서 
		// vector 안에 있는 객체들의 정보가 나옴.
		// 그런데 Pizza 클래스의 toString() 없으면 주소값 나오는 건 vector의 주소값이 나오는 게 아니라
		// vector 안에 있는 각각의 객체들의 주소값이 나온 거고 그래서 각각의 객체들을 toString() 해준 것.
		
		/*
		v.remove(index); --> 특정한 위치에 있는 걸 제거
		v.remove(o); --> 값을 제거
		*/
		
		//순서가 없는 알고리즘도 있음. 그런 애들은 API 보면 인덱스 개념이 없음.
		
		service.allMakePizza(v);
	}

}
