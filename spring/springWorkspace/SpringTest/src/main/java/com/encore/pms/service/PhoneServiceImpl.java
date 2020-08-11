package com.encore.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.pms.dao.IPhoneDAO;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

@Service
public class PhoneServiceImpl implements IPhoneService{
	
	@Autowired
	private IPhoneDAO iPhoneDAO;
	
	/* 
	 * Transactional
	insert, delete 하는 동안 다른 작업 못하게 함.
	데이터의 무결성은 굉장히 중요.
	이 작업을 DAO에서 안 하고 Service에서 함. DAO는 데이터만 가져옴.
	
	application-config.xml에 트랜잭션 처리 필요!
	 */
	@Transactional
	public int insert(Phone phone) {
		return iPhoneDAO.insert(phone);
	}
	
	@Transactional
	public int delete(List<String> list) {
		return iPhoneDAO.delete(list);
	}

	public Phone select(Phone phone) {
		return iPhoneDAO.select(phone);
	}

	public List<Phone> select() {
		return iPhoneDAO.select();
	}

	public UserInfo select(UserInfo user) {
		return iPhoneDAO.select(user);
	}
}
