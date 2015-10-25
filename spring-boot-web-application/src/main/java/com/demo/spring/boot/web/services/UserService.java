package com.demo.spring.boot.web.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.spring.boot.web.model.CurrentUser;
import com.demo.spring.boot.web.model.User;

public interface UserService extends UserDetailsService {

	public List<User> listAll();

	public User findById(String id);

	public User saveOrUpdate(User user) throws Exception;

	public User findOneByUsername(String username);

	public User findOneByEmail(String email);

	public boolean canAccessUser(CurrentUser user, String userId);

}
