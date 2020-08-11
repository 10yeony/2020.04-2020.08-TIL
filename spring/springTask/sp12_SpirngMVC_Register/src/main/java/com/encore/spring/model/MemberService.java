package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Member;

public interface MemberService {
	public List<Member> viewAllMember();
	public Member findMember(String id);
	public boolean idCheck(String id);
	public Member login(String id, String password);
	public void registerMember(Member vo);
	public void updateMember(Member vo);
}
