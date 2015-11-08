package com.demo.spring.boot.integration.amqp.model;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {
	private static final long serialVersionUID = -8603729633051970568L;

	private String name;
	private String email;
	private String title;
	private String question;
	private Date created;

	public Question() {
	}

	public Question(String name, String email, String title, String question) {
		this.name = name;
		this.email = email;
		this.title = title;
		this.question = question;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
