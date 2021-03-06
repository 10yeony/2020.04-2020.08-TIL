package com.encore.spring.model.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;

@Repository
public class MyProductDAOImpl implements MyProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String ns = "ProductMapper."; //namespace

	@Override
	public void addProduct(MyProduct vo) throws Exception {
		sqlSession.insert(ns+"addProduct", vo);
	}

	@Override
	public List<MyProduct> findByProductName(String name) throws Exception {
		return sqlSession.selectList(ns+"findByProductName", name);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return sqlSession.selectList(ns+"findProducts");
	}
	
}
