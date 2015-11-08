package com.demo.spring.boot.integration.amqp.get.dao;

import org.springframework.stereotype.Component;

@Component("questionDao")
public class QuestionDaoImpl implements QuestionDao {

	@Override
	public void handle(String payload) {
		System.out.println("wtf = " + payload);
	}

}
