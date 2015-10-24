package com.demo.spring.boot.web.dao;

import java.util.List;
import java.io.Serializable;

public interface GenericDao<T, ID extends Serializable> {

	T findById(ID id, boolean lock);

	List<T> findAll();

	List<T> findByExample(T exampleInstance, String... excludeProperty);

	T saveOrUpdate(T entity);

	void delete(T entity);

	/**
	 * Affects every managed instance in the current persistence context!
	 */
	void flush();

	/**
	 * Affects every managed instance in the current persistence context!
	 */
	void clear();
}
