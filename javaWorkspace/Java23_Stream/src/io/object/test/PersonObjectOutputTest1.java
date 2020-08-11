package io.object.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
 * ����ȭ �ڵ�...
 * Serialization :: Data Unpack
 * Person ��ü�� Sink ������ ������.
 * 1. ObjectOutputStream ����
 * 2. writeObject(object); 
 */
public class PersonObjectOutputTest1  {
	public static void main(String[] args) throws Exception {
		//1. ��Ʈ�� ����
		String fileName ="src\\person.obj"; // �������� Ȯ���� ����� ���� ��.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		
		//2. ��ü ����
		Person p = new Person("�迬��", 28, "kim99");
		
		//3. ������.
		oos.writeObject(p); // ������ ����ȭ�Ͽ� �Ѹ�.
		
		//4. �ڿ� �ݳ�...
		oos.close();
		System.out.println("person.obj ���Ͽ� ������ ������ �����߽��ϴ�.");
		System.out.println("������ Ȯ���Ϸ��� ������ȭ�ؼ� Ȯ�� �ٶ��ϴ�.");
		}

}
