package com.example.restdemo.controller;

import com.example.restdemo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/people")
    public List<Person> getAllPersons() {

        List<Person> people = List.of(
                new Person("John Doe", 30, "123 Main St"),
                new Person("Jane Smith", 25, "456 Maple Ave"),
                new Person("Bill Gates", 65, "789 Elm St")
        );

        return people;
    }
}