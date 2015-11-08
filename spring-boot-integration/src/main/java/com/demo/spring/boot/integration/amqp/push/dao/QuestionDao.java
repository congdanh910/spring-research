package com.demo.spring.boot.integration.amqp.push.dao;


import com.demo.spring.boot.integration.amqp.model.Question;

public interface QuestionDao {
	public boolean push(Question question);
}
