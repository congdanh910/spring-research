package com.demo.spring.hibernate.model;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by danh.ho on 23/07/2015.
 */
@Entity
@Table(name = "students")
public class Student implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    private Date birthday;

    public Student() {
    }

    public Student(String name, String address, String email, Date birthday) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
