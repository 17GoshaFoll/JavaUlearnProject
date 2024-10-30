package org.example;

import java.util.List;

public class Student extends Person {
    Integer group;
    Activity activity;
    List<Course> courses;
    public Student(Integer id, String name, Integer group, List<Course> courses, Activity activity) {
        super(id, name);
        this.group = group;
        this.courses = courses;
        this.activity = activity;
    }
}
