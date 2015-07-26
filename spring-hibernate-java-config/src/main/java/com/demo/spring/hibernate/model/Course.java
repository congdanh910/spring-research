package com.demo.spring.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by CongDanh on 7/26/15.
 */
@Entity
@Table(name = "courses")
public class Course implements Serializable {
    public static final String GOOD = "GOOD";
    public static final String NORMAL = "NORMAL";
    public static final String PASSED = "PASSED";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    private int duration; // calculator by month
    private String level;
    private boolean required;
    @Column(name = "create_date")
    private Date createDate;

    public Course() {
    }

    public Course(String name, int duration, String level, boolean required, Date createDate) {
        this.name = name;
        this.duration = duration;
        this.level = level;
        this.required = required;
        this.createDate = createDate;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequire(boolean required) {
        this.required = required;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
