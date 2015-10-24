package com.demo.spring.boot.web.dao;

import com.demo.spring.boot.web.model.User;

public interface UserDao extends GenericDao<User, String> {
	
	public User findOneByUsername(String username);

	public User findOneByEmail(String email);

}
