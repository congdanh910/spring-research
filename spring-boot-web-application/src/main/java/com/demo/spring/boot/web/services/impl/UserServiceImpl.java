package com.demo.spring.boot.web.services.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.boot.web.dao.UserDao;
import com.demo.spring.boot.web.model.CurrentUser;
import com.demo.spring.boot.web.model.Role;
import com.demo.spring.boot.web.model.User;
import com.demo.spring.boot.web.services.UserService;
import com.demo.spring.boot.web.utils.RedisKeysUtil;
import com.google.gson.Gson;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final Gson gson = new Gson();

	@Autowired
	private UserDao userDao;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public List<User> listAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(String id) {
		String userInRedis = redisTemplate.opsForValue().get(RedisKeysUtil.createUserKey(id));
		User find = null;
		if (StringUtils.isNotBlank(userInRedis)) {
			find = gson.fromJson(userInRedis, User.class);
		} else {
			find = userDao.findById(id, true);
			if (find != null) {
				redisTemplate.opsForValue().set(RedisKeysUtil.createUserKey(find.getId()), gson.toJson(find));
			}
		}
		return find;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public User saveOrUpdate(User user) throws Exception {
		User created = userDao.saveOrUpdate(user);
		redisTemplate.opsForValue().set(RedisKeysUtil.createUserKey(created.getId()), gson.toJson(created));
		return created;
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
