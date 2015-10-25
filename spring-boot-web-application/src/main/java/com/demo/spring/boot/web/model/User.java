package com.demo.spring.boot.web.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Email;

import com.demo.spring.boot.web.form.UserForm;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -9087880001805572992L;

	@Id
	@Size(max = 50)
	private String id;
	@NotNull
	@Size(min = 2, max = 50)
	@Column(unique = true)
	private String username;
	@NotNull
	@Size(min = 6, max = 20)
	private String password;
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	@NotNull
	private String name;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
	}

	public User(String id, UserForm userForm) throws Exception {
		if (StringUtils.isBlank(id) || userForm == null) {
			throw new Exception("Userform is null or Id is null!");
		}
		this.id = id;
		this.username = userForm.getUsername();
		this.password = userForm.getPassword();
		this.name = userForm.getEmail();
		this.email = userForm.getEmail();
		this.role = Role.valueOf(userForm.getRole());
		if (StringUtils.isNotBlank(userForm.getId())) {
			this.updatedAt = new Timestamp(new Date().getTime());
		} else {
			this.createdAt = new Timestamp(new Date().getTime());
			this.password = userForm.getPassword();
		}
	}

	public User(String id, String username, String password, String email, String name, Timestamp createdAt,
			Timestamp updatedAt) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
