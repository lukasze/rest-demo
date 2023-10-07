package com.example.restdemo.model;

import jakarta.persistence.*;



/*
    TODO 1: Read all the comments in this class, and make some notes :)

    Mapping a class/object to a table/ table's row


    +-----------------------+
    |     Person Class      |
    +-----------------------+
    | - Long id             |           +-------------------------+
    | - String name         |           |      person Table       |
    | - int age             |       ⟷   +-------------------------+
    | - String address      |           | ID (Primary Key)        |
    +-----------------------+           | NAME                    |
                                        | AGE                     |
                                        | ADDRESS                 |
                                        +-------------------------+
 new Person("John", 30, "123 St")       | 1  | John | 30 | 123 St |
                                        |-------------------------|
 new Person("Jane", 25, "456 Rd")       | 2  | Jane | 25 | 456 Rd |
                                        |-------------------------|
 new Person("Mike", 22, "789 Ln")       | 3  | Mike | 22 | 789 Ln |
                                        +-------------------------+
 */


/*

    @Entity - the superpower that changes e regular class into ... and Entity :)
    - Hibernate (an ORM framework) will map:
    - Person class into person table in a relational DB
    - person object into the table's row
 */
@Entity
public class Person {

    /*
        A new field with some annotations: id will become the Primary Key on the Database side.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String address;
    /*
        The role of a no-arg-constructor.

        Hibernate will use it, with setters and getters, to create objects based on the rows in the table.
     */
    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
