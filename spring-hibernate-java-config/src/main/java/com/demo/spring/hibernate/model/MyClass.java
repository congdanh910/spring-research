package com.demo.spring.hibernate.model;

import org.hibernate.LazyInitializationException;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danh.ho on 24/07/2015.
 */
@Entity
@Table(name = "classes")
public class MyClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<Student>();

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    public MyClass(String name) {
        this.name = name;
    }

    public MyClass() {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        try {
            return this.name + ", [" + this.students + "]" + ", [" + this.teacher + "]";
        } catch (LazyInitializationException ex) {
            return this.name + ", [Students is NULL --> Lazy loading is false!]" + ", [Teacher is NULL --> Lazy loading is false!]";
        }
    }
}

