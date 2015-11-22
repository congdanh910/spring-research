package com.demo.spring.boot.integration.amqp.get.task;

import com.demo.spring.boot.integration.amqp.model.Question;

public class QuestionTask implements Runnable {

	private Question question;
	private long start;

	public QuestionTask(Question question, long start) {
		this.question = question;
		this.start = start;
	}

	@Override
	public void run() {
		System.out.println("Question  : " + question.getName() + ", start : " + start);
	}

}
