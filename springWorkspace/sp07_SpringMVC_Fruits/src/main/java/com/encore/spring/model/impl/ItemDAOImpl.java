package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemCatalogImpl;

@Repository
public class ItemDAOImpl implements ItemCatalogImpl {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NS = "ItemMapper.";

	@Override
	public List<Item> getAllItem() throws Exception {
		return sqlSession.selectList(NS+"getAllItem");
	}

	@Override
	public Item getItem(int itemNumber) throws Exception {
		return sqlSession.selectOne(NS+"getItem", itemNumber);
	}

	@Override
	public void updateRecordCount(int itemNumber) throws Exception {
		sqlSession.update(NS+"updateRecordCount", itemNumber);
		
	}
}
