package collection.test1;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// System.get~ // static일 때 쓸 수 있음.
		// System.getProperties(); // 전부 다 가져올 때.
		Properties p = System.getProperties(); // p에 Properties를 가져오는 기능을 저장.
		Enumeration en=p.propertyNames(); // Enumeration 타입의 en에 p의 키를 저장.
		// Enumeration 인터페이스의 메소드는 2가지 밖에 없음.
		// hasMoreElments(), nextElement()
		// 있을 때까지 돈다. while문!
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = p.getProperty(name); // key만 알면 value가 봅힘.
			System.out.println(name+"============"+value);
		}

	}

}
