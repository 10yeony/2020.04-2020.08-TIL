package spring.service.dice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dice.play.Player02;
public class DiceTestAppUseSpring {
	public static void main(String[] args) {
		/* 1. BeanFactory 생성... 주문서는 공장에서 미리 받아서 읽어놔야 한다. */
		System.out.println("1. BeanFactory... 생성...");
		
		//BeanFactory 생성할 때 주문서와 함께 인자값으로 넣어준다.
		// 주문서 = Bean Configuration File(Bean 설정 문서)
		//BeanFactory가 추상 클래스이므로 자식 클래스로 객체 생성
		//XmlBeanFactory는 폐기될 구버전... 하지만 동작 원리를 알기 위해 쓰겠다.
				
		//FilePathSystem으로 불러와서 src 인식 못함
		BeanFactory factory = 
				new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/diceService.xml"));
		
		//2. getBean()으로 빈을 받아와서 playDice(), getTotalValue() 호출
		//빈 공장을 먼저 만들어놓고 클라이언트가 요청(getBean())하면 그제서야 만들어짐.(Lazy Loading)
		System.out.println("2. getBean().... 클라이언트 호출...");
		Player02 player01 = (Player02)factory.getBean("player01");
		System.out.println("3. ↑ getBean() 호출 이후에 컨테이너가 객체 생성한 것 확인...");
		player01.playDice(3);
		System.out.println("======================");
		System.out.println("선택된 주사위 수의 총합은 :"+ player01.getTotalValue());
		System.out.println("=============\n\n");
		
		//2. getBean()으로 빈을 받아와서 playDice(), getTotalValue() 호출
		//빈 공장을 먼저 만들어놓고 클라이언트가 요청(getBean())하면 그제서야 만들어짐.(Lazy Loading)
		System.out.println("2. getBean().... 클라이언트 호출...");
		Player02 player02 = (Player02)factory.getBean("player02");
		System.out.println("3. ↑ getBean() 호출 이후에 컨테이너가 객체 생성한 것 확인...");
		player02.playDice(3);
		System.out.println("======================");
		System.out.println("선택된 주사위 수의 총합은 :"+ player02.getTotalValue());
		System.out.println("=============\n\n");
		
		
		//2. getBean()으로 빈을 받아와서 playDice(), getTotalValue() 호출
		//빈 공장을 먼저 만들어놓고 클라이언트가 요청(getBean())하면 그제서야 만들어짐.(Lazy Loading)
		System.out.println("2. getBean().... 클라이언트 호출...");
		Player02 player03 = (Player02)factory.getBean("player03");
		System.out.println("3. ↑ getBean() 호출 이후에 컨테이너가 객체 생성한 것 확인...");
		player03.playDice(3);
		System.out.println("======================");
		System.out.println("선택된 주사위 수의 총합은 :"+ player03.getTotalValue());
		System.out.println("=============\n\n");
		
		//2. getBean()으로 빈을 받아와서 playDice(), getTotalValue() 호출
		//빈 공장을 먼저 만들어놓고 클라이언트가 요청(getBean())하면 그제서야 만들어짐.(Lazy Loading)
		System.out.println("2. getBean().... 클라이언트 호출...");
		Player02 player04 = (Player02)factory.getBean("player04");
		System.out.println("3. ↑ getBean() 호출 이후에 컨테이너가 객체 생성한 것 확인...");
		player04.playDice(3);
		System.out.println("======================");
		System.out.println("선택된 주사위 수의 총합은 :"+ player04.getTotalValue());
		System.out.println("=============\n\n");
	
	}
	
}//end of class