package com.demo.spring.boot.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CongDanh on 10/10/15.
 */
public class Student implements Serializable {
    private long id;
    private String fistName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String homePhone;
    private Date birthday;

    public Student(long id, String fistName, String lastName, String address, String email, String phone, String homePhone, Date birthday) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.homePhone = homePhone;
        this.birthday = birthday;
    }

    public Student() {
    }

    public Student(long id, String fistName, String lastName) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
