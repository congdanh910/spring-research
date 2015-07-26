package com.demo.spring.hibernate.main;


import com.demo.spring.hibernate.config.HibernateConfiguration;
import com.demo.spring.hibernate.model.Course;
import com.demo.spring.hibernate.model.MyClass;
import com.demo.spring.hibernate.model.Student;
import com.demo.spring.hibernate.model.Teacher;
import com.demo.spring.hibernate.services.MyClassService;
import com.demo.spring.hibernate.services.StudentService;
import com.demo.spring.hibernate.services.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by danh.ho on 23/07/2015.
 */
public class Main {

    private static List<Teacher> teachers = new ArrayList<Teacher>();

    private static List<Student> students = new ArrayList<Student>();

    private static List<Student> students1 = new ArrayList<Student>();

    private static List<Course> courses = new ArrayList<Course>();

    private static List<Course> courses1 = new ArrayList<Course>();

    private static List<MyClass> classes = new ArrayList<MyClass>();

    static {

        // courses
        courses.add(new Course("EL 1", 6, Course.GOOD, true, new Date()));
        courses.add(new Course("EL 2", 6, Course.GOOD, true, new Date()));

        courses1.add(new Course("IT 1", 3, Course.NORMAL, false, new Date()));
        courses1.add(new Course("IT 2", 4, Course.PASSED, false, new Date()));

        //students
        students.add(new Student("<<Danh Ho>> 1", "Tien Giang 1", "congdanh123@gmail.com", new Date(), courses, new Date()));
        students.add(new Student("<<Danh Ho>> 2", "Tien Giang 2", "congdanh456@gmail.com", new Date(), courses1, new Date()));
        students.add(new Student("<<Danh Ho>> 3", "Tien Giang 3", "congdanh789@gmail.com", new Date()));
        students.add(new Student("<<Danh Ho>> 4", "Tien Giang 4", "congdanh012@gmail.com", new Date()));
        students.add(new Student("<<Danh Ho>> 5", "Tien Giang 5", "congdanh345@gmail.com", new Date()));

        students1.add(new Student("<<Beckham>> 1", "UK", "uk123@gmail.com", new Date()));
        students1.add(new Student("<<Beckham>> 2", "UK", "uk456@gmail.com", new Date()));
        students1.add(new Student("<<Beckham>> 3", "UK", "uk345@gmail.com", new Date()));

        //teachers
        teachers.add(new Teacher("<<Teacher 1>>", "Hometown 1", new Date()));
        teachers.add(new Teacher("<<Teacher 2>>", "Hometown 2", new Date()));
        teachers.add(new Teacher("<<Teacher 3>>", "Hometown 3", new Date()));
        teachers.add(new Teacher("<<Teacher 4>>", "Hometown 4", new Date()));
        teachers.add(new Teacher("<<Teacher 5>>", "Hometown 5", new Date()));
    }


    public static void main(String[] args) {
        // application context
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
        //AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
        //context.scan("com.websystique.spring");
        //context.refresh();inverse

        // services
        StudentService studentService = context.getBean("studentService", StudentService.class);
        TeacherService teacherService = context.getBean("teacherService", TeacherService.class);
        MyClassService myClassService = context.getBean("myClassService", MyClassService.class);

        //Classes
        MyClass class1 = new MyClass("<<Class 1>>");
        class1.setTeacher(teachers.get(0));
        class1.setStudents(students);

        MyClass class2 = new MyClass("<<Class 2>>");
        class2.setTeacher(teachers.get(1));
        class2.setStudents(students1);

        MyClass class3 = new MyClass("<<Class 3>>");
        class3.setTeacher(teachers.get(2));

        MyClass class4 = new MyClass("<<Class 4>>");
        class4.setTeacher(teachers.get(3));

        MyClass class5 = new MyClass("<<Class 5>>");
        class5.setTeacher(teachers.get(4));

        // persistence
        /*
        myClassService.makePersistent(class1);
        myClassService.makePersistent(class2);
        myClassService.makePersistent(class3);
        myClassService.makePersistent(class4);
        myClassService.makePersistent(class5);
        */

        //queries
        /*
        - Fetch Types :
            1. default loading (fetch = FetchType.LAZY) --> Don’t load the relationships unless explicitly “asked for” via getter
                1.1 @Fetch(FetchMode.SELECT) --> it is default value of fetch mode if we don't set.
                1.2. @Fetch(FetchMode.JOIN) --> Will load all relationships by inner join tables

            2. fetch=FetchType.EAGER --> Will load ALL relationships

        - Which one is good?
            EAGER: Convenient, but SLOW
            LAZY: More coding, but much more efficient

         */
        MyClass classLoading = myClassService.getStudentsOfClass(1L);
        System.out.println(classLoading);

        for (Student student : classLoading.getStudents()) {
            System.out.println(student.getName());
        }
    }
}
