package io.object.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
 * 직렬화 코드...
 * Serialization :: Data Unpack
 * Person 객체를 Sink 쪽으로 날린다.
 * 1. ObjectOutputStream 생성
 * 2. writeObject(object); 
 */
public class PersonObjectOutputTest1  {
	public static void main(String[] args) throws Exception {
		//1. 스트림 생성
		String fileName ="src\\person.obj"; // 가상으로 확장자 만들어 놓은 것.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
		
		//2. 객체 생성
		Person p = new Person("김연아", 28, "kim99");
		
		//3. 날린다.
		oos.writeObject(p); // 정보를 직렬화하여 뿌림.
		
		//4. 자원 반납...
		oos.close();
		System.out.println("person.obj 파일에 연아의 정보를 저장했습니다.");
		System.out.println("정보를 확인하려면 역직렬화해서 확인 바랍니다.");
		}

}
