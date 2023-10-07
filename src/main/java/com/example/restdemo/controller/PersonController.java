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

    /*
        TODO 1 Run the application the test your app's Get/Post endpoints it with Swagger

        TODO 2 Check with ChatGPT the role of @RequestBody annotation
     */
    @PostMapping("/people")
    public Person savePerson(@RequestBody Person newPerson) {
        Person savedPerson = personRepository.save(newPerson);
        return savedPerson;
    }
}