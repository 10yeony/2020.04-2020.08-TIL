package ibatis.services.user.test;

import ibatis.services.domain.User;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * FileName : MyBatisTestApp02.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping02.xml
  * ㅇ My Framework 이용 QUERY ( SELECT ) TEST 
  */
public class 	MyBatisTestApp02 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		/* LIKE 연산자와 와일드카드를 같이 써야 함. */
		
		//0. getUser :: # 대입자를 이용한 like 연산자 검색 ==> 검색결과 없는 것 확인 
		System.out.println(":: 0. user로 시작하는 userId User(SELECT)  ? ");
		List<User> list = session.selectList("UserMapper02.getUser01","user");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//1. getUser :: # 대입자를 이용한 like 연산자 검색 // ==> 검색결과 존재 확인 :: %와일드카드 직접 입력한 경우
		System.out.println(":: 1. user로시작하는 userId User(SELECT)  ? "); 
		list = session.selectList("UserMapper02.getUser01","user%"); 
		for (int i =0 ; i < list.size() ; i++) { 
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() ); 
		} 
		System.out.println("\n");
		 
		//2. getUser :: # 대입자를 이용한 like 연산자 검색 ==> 검색결과 없는 것 확인 
		User user = new User(); 
		user.setUserId("01");
		  
		System.out.println(":: 2. 01로 끝나는 userId User(SELECT)  ? "); 
		list =
		session.selectList("UserMapper02.getUser02",user); 
		for (int i =0 ; i < list.size() ; i++) { 
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() ); 
		} 
		System.out.println("\n");
		
		//3. getUser :: # 대입자를 이용한 like 연산자 검색 // ==> 검색결과 존재 확인 :: %와일드카드 직접입력경우
		user.setUserId("%01");
		System.out.println(":: 3. 01로 끝나는 userId User(SELECT)  ? "); 
		list = session.selectList("UserMapper02.getUser02",user); 
		for (int i =0 ; i < list.size() ; i++) { 
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() ); 
		} 
		System.out.println("\n");
		
		//4. getUser :: $ 대입자를 이용한 like 연산자 검색==> 검색결과 존재 확인
		System.out.println(":: 4. user로 시작하는 userId User(SELECT)  ? "); 
		list = session.selectList("UserMapper02.getUser03","user"); 
		for (int i =0 ; i < list.size() ; i++) { 
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() ); 
		} 
		System.out.println("\n");
	
		//5. getUser :: $ 대입자를 이용한 like 연산자 검색==> 검색결과 존재 확인 user.setUserId("01");
		System.out.println(":: 5. 01로 끝나는 userId User(SELECT)  ? "); 
		list = session.selectList("UserMapper02.getUser04", user); 
		for (int i =0 ; i < list.size() ; i++) { 
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() ); 
		} 
		System.out.println("\n");
		
		//6. getUser :: $ 대입자를 이용한 like 연산자 검색==> 검색결과 존재 확인 user.setUserId("01");
		System.out.println(":: 6. user가 포함되는 userId User(SELECT)  ? "); 
		list = session.selectList("UserMapper02.getUser05", "user"); 
		for (int i =0 ; i < list.size() ; i++) { 
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() ); 
		} 
		System.out.println("\n"); 
	}//end of main
}//end of class






