package com.tsp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tsp.dao.ProductDao;
import com.tsp.model.Product;
import com.tsp.services.ProductService;

public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao prodcutDao;

	public Product getProduct(String id) {
		System.out.println("product id=" + id);
		return prodcutDao.getProduct(id);
	}

	public Product saveProduct(Product product) {
		return prodcutDao.saveProduct(product);

	}

}
