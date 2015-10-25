package com.demo.spring.boot.web.utils;

import java.text.MessageFormat;

public class RedisKeysUtil {
	public static final String REDIS_USER_RECENTLY_MODIFIED_KEY = "user:recently-modified";
	private static final String REDIS_USER_KEY = "user:{0}";

	public static String createUserKey(String id) {
		return MessageFormat.format(REDIS_USER_KEY, id);
	}
}
