package com.spring.aop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "test_test")
public class Test implements Serializable {
	private static final long serialVersionUID = 683897912831626931L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "salary_gross")
	private double salaryGross;

	public Test() {
	}

	public Test(String name, int age, Date createDate, double salaryGross) {
		this.name = name;
		this.age = age;
		this.createDate = createDate;
		this.salaryGross = salaryGross;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getSalaryGross() {
		return salaryGross;
	}

	public void setSalaryGross(double salaryGross) {
		this.salaryGross = salaryGross;
	}

}
