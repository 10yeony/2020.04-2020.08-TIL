package com.encore.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.encore.mybatis.vo.MySawon;

/*
 * mysawon 테이블에 있는 모든 사원의 정보를 출력하는 코드
 */
public class SimpleMyBatisAppTest2 {

	public static void main(String[] args) {
		try {
			//1. SQLMapConfig.xml을 읽어들인다.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			//2. SqlSessionFactory를 리턴받는다.
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			//3. SqlSession을 리턴받는다.
			SqlSession session = factory.openSession();
			
			/* SqlSession
			 * 
			 * query statement
			 * INSERT INTO ------------- insert()
			 * DELETE FROM ------------- delete()
			 * UPDATE table ------------ update()
			 * SELECT all -------------- List selectList()
			 * SELECT one -------------- Object selectOne()
			 */
			List<MySawon> list = session.selectList("mysawonMapper.sawonList");
			
			for(MySawon vo : list) {
				System.out.println(vo.getId()+", "+vo.getName()+", "+vo.getHiredate());
			}
			session.close(); //spring DI Framework일 때는 들어가 있다..
			
		}catch(Exception e) {
			System.out.println("불러오기 실패!!!");
		}

	}

}
