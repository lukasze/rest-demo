package com.example.restdemo.controller;

import com.example.restdemo.repository.PersonRepository;
import com.example.restdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/people")
    public List<Person> getAllPersons() {

        return personRepository.findAll();
    }

    @PostMapping("/people")
    public Person savePerson(@RequestBody Person newPerson) {
        Person savedPerson = personRepository.save(newPerson);
        return savedPerson;
    }
}