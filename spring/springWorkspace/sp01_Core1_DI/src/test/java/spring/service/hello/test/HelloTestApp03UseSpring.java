package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Hello;

public class HelloTestApp03UseSpring {
/*
 * 파일 읽어올 때
 * ClassPathSystem으로 읽어올 때 - src를 이미 먹고 들어간다.
 * FilePathSystem으로 읽어올 때 - 파일은 src 인식 못하므로 src부터 다시 인식시켜야 한다.
 */
	public static void main(String[] args) {
		System.out.println("1. BeanFactory... 생성...");
		//1. BeanFactory 생성... 주문서는 공장에서 미리 받아서 읽어놔야 한다.
		//BeanFactory 생성할 때 주문서와 함께 인자값으로 넣어준다.
		// 주문서 = Bean Configuration File(빈 설정 문서)
		
		//BeanFactory가 추상 클래스이므로 자식 클래스로 객체 생성
		//XmlBeanFactory는 폐기될 구버전... 하지만 동작 원리를 알기 위해 쓰겠다.
		
		//FilePathSystem으로 불러와서 src 인식 못함
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource
				("./src/main/resources/config/hello.xml"));
		
		//빈 공장을 먼저 만들어놓고 클라이언트가 요청(getBean())하면 그제서야 만들어짐.(Lazy Loading)
		
		System.out.println("2. getBean().... 클라이언트 호출...");
		
		//2. getBean()으로 빈을 받아와서 printMessage() 호출
		Hello hello = (Hello)factory.getBean("hello"); //Hello 말고 인터페이스가 와야 함.
		hello.printMessage();
		
	}

}
