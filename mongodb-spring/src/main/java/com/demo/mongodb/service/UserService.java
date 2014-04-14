package com.demo.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mongodb.domain.Role;
import com.demo.mongodb.domain.User;
import com.demo.mongodb.repository.RoleRepository;
import com.demo.mongodb.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;

	public User create(User user) {
		if (user.getRole() != null) {
			Role find = roleRepository.findByRole(user.getRole().getRole());
			if (find == null) {
				roleRepository.save(user.getRole());
			} else {
				user.setRole(find);
			}
		}
		return userRepository.save(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
