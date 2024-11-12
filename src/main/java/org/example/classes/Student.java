package org.example.classes;

import java.util.List;

public class Student {
    Activity activity;
    String name;
    String group;
    Course courses;
    public Student(String name, String group, Course courses) {
        this.group = group;
        this.name = name;
        this.courses = courses;
        //this.activity = activity;
    }
}
