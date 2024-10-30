package org.example;

public abstract class Person {
    String name;
    Integer id;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
