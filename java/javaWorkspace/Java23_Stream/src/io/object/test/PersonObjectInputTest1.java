package io.object.test;
/*
 * 역직렬화 :: DataPack
 */
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PersonObjectInputTest1  {
	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\person.obj"));
		
		Person p = (Person) ois.readObject(); //역직렬화
		// 무조건 Object로 돌려줘서... Person 타입으로 캐스팅해줘야 함.
		System.out.println(p);
		
		}

}
