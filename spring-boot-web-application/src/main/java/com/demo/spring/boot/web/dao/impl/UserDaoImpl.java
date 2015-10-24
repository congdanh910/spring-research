package com.demo.spring.boot.web.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.demo.spring.boot.web.dao.UserDao;
import com.demo.spring.boot.web.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, String> implements UserDao {

	@Autowired
	public UserDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public User findOneByEmail(String email) {
		Criteria crt = getSession().createCriteria(User.class);
		crt.add(Restrictions.eq("email", email));
		return (User) crt.uniqueResult();
	}

	@Override
	public User findOneByUsername(String username) {
		Criteria crt = getSession().createCriteria(User.class);
		crt.add(Restrictions.eq("username", username));
		return (User) crt.uniqueResult();
	}

}
