package com.demo.spring.boot.integration.amqp.push.dao;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.demo.spring.boot.integration.amqp.model.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component("questionDao")
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	@Qualifier("fanoutTemplate")
	private RabbitTemplate fanoutTemplate;

	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	@Override
	public boolean push(Question question) {
		try {
			fanoutTemplate.convertAndSend(gson.toJson(question));
			return true;
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
