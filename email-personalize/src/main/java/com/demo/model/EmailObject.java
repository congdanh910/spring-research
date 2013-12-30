package com.demo.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EmailObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private int age;
	private String city;
	private String phone;
	private String email;

	public EmailObject() {
	}

	public EmailObject(String firstName, String lastName, int age, String city,
			String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
		this.phone = phone;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, String> mapper() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Field[] fields = this.getClass().getDeclaredFields();
			for (Field field : fields) {
				map.put(field.getName(), (field.get(this) != null) ? field.get(this).toString()	: "");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
}
