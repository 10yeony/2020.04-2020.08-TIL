package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Item;

public interface ItemCatalog {
	public List<Item> getAllItem() throws Exception;
	public Item getItem(int itemNumber) throws Exception;
	public void updateRecordCount(int itemNumber) throws Exception;
}