package com.demo.spring.boot.web.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.boot.web.dao.UserDao;
import com.demo.spring.boot.web.model.CurrentUser;
import com.demo.spring.boot.web.model.Role;
import com.demo.spring.boot.web.model.User;
import com.demo.spring.boot.web.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> listAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(String id) {
		return userDao.findById(id, true);
	}
	
	@Override
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}

	@Override
	public User findOneByUsername(String username) {
		return userDao.findOneByUsername(username);
	}

	@Override
	public User findOneByEmail(String email) {
		return userDao.findOneByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User findByUsername = userDao.findOneByUsername(username);
		if (findByUsername == null) {
			throw new UsernameNotFoundException("Can not find the User with this username and password!");
		}
		return new CurrentUser(findByUsername);
	}

	@Override
	public boolean canAccessUser(CurrentUser user, String userId) {
		return user != null && (user.getRole() == Role.ADMIN || user.getId().equals(userId));
	}

}
