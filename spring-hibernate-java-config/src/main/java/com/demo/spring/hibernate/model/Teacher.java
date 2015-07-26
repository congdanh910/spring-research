package com.demo.spring.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by danh.ho on 24/07/2015.
 */
@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    private Date birthday;

    public Teacher(String name, String address, Date birthday) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }

    public Teacher() {

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
