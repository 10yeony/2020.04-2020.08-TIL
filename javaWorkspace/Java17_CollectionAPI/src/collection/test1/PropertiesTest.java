package collection.test1;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// System.get~ // static�� �� �� �� ����.
		// System.getProperties(); // ���� �� ������ ��.
		Properties p = System.getProperties(); // p�� Properties�� �������� ����� ����.
		Enumeration en=p.propertyNames(); // Enumeration Ÿ���� en�� p�� Ű�� ����.
		// Enumeration �������̽��� �޼ҵ�� 2���� �ۿ� ����.
		// hasMoreElments(), nextElement()
		// ���� ������ ����. while��!
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = p.getProperty(name); // key�� �˸� value�� ����.
			System.out.println(name+"============"+value);
		}

	}

}
