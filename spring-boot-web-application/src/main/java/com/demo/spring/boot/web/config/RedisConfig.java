package com.demo.spring.boot.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	@Value("${redis.hostName}")
	private String hostName;

	@Value("${redis.port}")
	private int port;

	@Value("${redis.password}")
	private String password;

	@Value("${redis.pool.max.idle}")
	private int maxIdle;

	@Value("${redis.pool.max.total}")
	private int maxTotal;

	@Value("${redis.pool.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${redis.pool.testOnReturn}")
	private boolean testOnReturn;

	@Bean
	public RedisConnectionFactory connectionFactory() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxTotal(maxTotal);
		jedisPoolConfig.setTestOnBorrow(testOnBorrow);
		jedisPoolConfig.setTestOnReturn(testOnReturn);

		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(jedisPoolConfig);
		connectionFactory.setUsePool(true);
		connectionFactory.setHostName(hostName);
		connectionFactory.setPort(port);
		connectionFactory.setPassword(password);
		return connectionFactory;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean(name = "redisTemplate")
	public RedisTemplate redisTemplate() {
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(connectionFactory());
		redisTemplate.setDefaultSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}
