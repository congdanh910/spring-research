package com.demo.spring.boot.integration.amqp.get.dao;

public interface QuestionDao {
	// why we return void here? ==> If we return something, it means we will process something more
	// and the message from RabbitMQ will NOT delete and throws some exceptions at runtime
	// we intend to handle everything here, so when we got the message from Queue, we don't return anything 
	public void handle(String payload);
}
