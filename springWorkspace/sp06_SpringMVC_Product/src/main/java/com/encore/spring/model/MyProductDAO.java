package com.encore.spring.model;

import java.sql.SQLException;
import java.util.List;

import com.encore.spring.domain.MyProduct;

public interface MyProductDAO {
	public void addProduct(MyProduct vo) throws Exception;
	public List<MyProduct> findByProductName(String words) throws Exception;
	public List<MyProduct> findProducts() throws Exception;
}
