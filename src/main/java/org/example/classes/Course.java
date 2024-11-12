package org.example.classes;

import java.util.List;

public class Course {
    String title;
    List<Theme> theme;

    public Course(String title, List<Theme> theme)
    {
        this.theme = theme;
        this.title = title;
    }
    //public String toString(){
    //    return String.format()
    //}
}
