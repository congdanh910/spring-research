package com.demo.spring.boot.controller;

import com.demo.spring.boot.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CongDanh on 10/10/15.
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Student> list() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1L, "Danh", "Ho"));
        students.add(new Student(2L, "Khang", "Dang"));
        students.add(new Student(3L, "Baby", "Ho"));
        return students;
    }
}
