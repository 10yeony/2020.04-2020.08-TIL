package com.encore.spring;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Member;

public class MyBatisJunitTest1 {
	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Member vo;
		
		/* registerMember */
		vo = new Member("8888", "pwd1234", "이름", "주소");
		session.insert("MemberMapper.registerMember", vo);
		session.commit();
		
		/* updateMember */
		vo = new Member("1111", "1111", "1111", "1111");
		session.update("MemberMapper.updateMember", vo);
		session.commit();
		
		/* findMember */
		vo = session.selectOne("MemberMapper.findMember", "11");
		System.out.println(vo);
		System.out.println("====================");
		
		/* viewAllMember */
		List<Member> list = session.selectList("MemberMapper.viewAllMember");
		for(Member i : list) {
			System.out.println(i);
		}
		
		System.out.println("===============================================");
		
	}
}
