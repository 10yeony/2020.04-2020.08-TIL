package spring.service.dice.test;
import spring.service.dice.impl.DiceAImpl;
import spring.service.dice.impl.DiceBImpl;
import spring.service.dice.impl.DiceCImpl;
//Spring 안 쓰고 인터페이스만으로 이렇게 재사용성을 높일 수 있다....
import spring.service.dice.play.Player02;

/*
 * FileName : DiceTestApp01.java
 * ㅇ DiceA / Player01 Test 하는 Application 
 */
public class DiceTestApp02 {
	///Main Method
	public static void main(String[] args){
		
		Player02 player01 = new Player02(new DiceAImpl()); 
		//new가 나오면 안 됨. 객체 생성을 내가 하면 실체 클래스가 드러남. BeanFactory가 만들게 해야 함.
		
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player02 = new Player02(new DiceBImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player03 = new Player02(new DiceCImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
	}
}//end of class

