package com.demo.spring.boot.web.redis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;

import com.demo.spring.boot.web.model.User;
import com.demo.spring.boot.web.utils.RedisKeysUtil;
import com.google.gson.Gson;

public class UserToCache implements SessionCallback<List<Object>> {

	private User user;
	private final Gson gson = new Gson();

	public UserToCache(User user) throws Exception {
		if (user == null) {
			throw new Exception("User can not be null!");
		}
		this.user = user;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Object> execute(RedisOperations operations) throws DataAccessException {
		String userKey = RedisKeysUtil.createUserKey(user.getId());

		operations.multi();
		operations.opsForValue().set(userKey, gson.toJson(user));
		operations.opsForSet().add(RedisKeysUtil.REDIS_USER_RECENTLY_MODIFIED_KEY, userKey);

		return operations.exec();
	}

}
