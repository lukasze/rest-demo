package com.example.restdemo.controller;

import com.example.restdemo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    TODO 1:  5-minute discussion within your team (write down your thoughts/questions):

    Can you explain the role of:
    - @RestController?
    - @GetMapping?
    - @RequestParam?
    - @RequestMapping?

    TODO 2: Read the comments in this class

 */

@RestController
public class PersonController {

    @GetMapping("/people")
    // 'List<Person>' represents a declaration of a list that can contain only objects of type 'Person'.
    public List<Person> getAllPersons() {
        /*
            Java List is similar to a notebook.
            It's a digital "container" where you can store objects (like book names) in a specific order.
            And just as you can check any line in your notebook to see which book you wrote down,
            in a Java List, you can quickly access any item based on its position in the list.

         */

        // 'List.of(...)' is a method introduced in Java 9 which provides an immutable list of given elements.
        List<Person> people = List.of(
                new Person("John Doe", 30, "123 Main St"),
                new Person("Jane Smith", 25, "456 Maple Ave"),
                new Person("Bill Gates", 65, "789 Elm St")
        );

        return people;
    }
}