package io.object.test;
/*
 * ������ȭ :: DataPack
 */
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PersonObjectInputTest1  {
	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\person.obj"));
		
		Person p = (Person) ois.readObject(); //������ȭ
		// ������ Object�� �����༭... Person Ÿ������ ĳ��������� ��.
		System.out.println(p);
		
		}

}
