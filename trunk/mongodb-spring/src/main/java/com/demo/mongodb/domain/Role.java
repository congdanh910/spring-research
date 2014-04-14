package com.demo.mongodb.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String role;

	public Role() {
	}

	public Role(String id, String role) {
		this.id = id;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
