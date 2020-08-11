package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Member;
import com.encore.spring.model.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Member> viewAllMember() {
		return sqlSession.selectList("MemberMapper.viewAllMember");
	}

	@Override
	public Member findMember(String id) {
		return sqlSession.selectOne("MemberMapper.findMember", id);
	}

	@Override
	public void registerMember(Member vo) {
		System.out.println("registerMember : "+sqlSession.insert("MemberMapper.registerMember", vo));
	}

	@Override
	public void updateMember(Member vo) {
		System.out.println("updateMember : "+sqlSession.update("MemberMapper.updateMember", vo));
	}

}
