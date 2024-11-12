package org.example.classes;

import lombok.Getter;

public class Part_of_Theme {
    @Getter
    String name;
    Integer max_point = 0;

    public Part_of_Theme(Integer max_point, String name) {
        this.max_point = max_point;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("%s , %s", name,max_point);
    }
}
