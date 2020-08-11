package com.encore.spring.model;

import java.sql.SQLException;
import java.util.List;

import com.encore.spring.domain.MyProduct;

public interface MyProductService {
	public void addProduct(MyProduct vo) throws Exception;
	public List<MyProduct> findByProductName(String name) throws Exception;
	public List<MyProduct> findProducts() throws Exception;
}
