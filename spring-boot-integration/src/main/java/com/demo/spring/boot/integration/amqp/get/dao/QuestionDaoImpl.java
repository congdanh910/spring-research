package com.demo.spring.boot.integration.amqp.get.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.spring.boot.integration.amqp.get.task.QuestionTask;
import com.demo.spring.boot.integration.amqp.get.thread.ThreadPoolService;
import com.demo.spring.boot.integration.amqp.model.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component("questionDao")
public class QuestionDaoImpl implements QuestionDao {

	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	@Autowired
	private ThreadPoolService threadService;

	@Override
	public void handle(String payload) {
		System.out.println("wtf = " + payload);

		// transfer payload to question
		Question question = gson.fromJson(payload, Question.class);

		// create and execute task
		QuestionTask questionTask = new QuestionTask(question, System.currentTimeMillis());
		threadService.execute(questionTask);
		
		System.err.println("\n---------------------------------------------\n");
		System.err.println("getCompletedTaskCount : " + this.threadService.getCompletedTaskCount());
		System.err.println("getLargestPoolSize : " + this.threadService.getLargestPoolSize());
		System.err.println("getTaskCount : " + this.threadService.getTaskCount());
		System.out.println("---------------------------------------------\n");
	}

}
