package com.encore.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemCatalogImpl;
import com.encore.spring.model.ItemCatalog;

@Service
public class ItemServiceImpl implements ItemCatalog {
	
	@Autowired
	private ItemCatalogImpl itemDao;

	@Override
	public List<Item> getAllItem() throws Exception {
		return itemDao.getAllItem();
	}

	@Override
	public Item getItem(int itemNumber) throws Exception {
		return itemDao.getItem(itemNumber);
	}

	@Override
	public void updateRecordCount(int itemNumber) throws Exception {
		itemDao.updateRecordCount(itemNumber);
	}

}
