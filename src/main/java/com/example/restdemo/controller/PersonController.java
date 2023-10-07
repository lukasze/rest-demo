package com.example.restdemo.controller;

import com.example.restdemo.repository.PersonRepository;
import com.example.restdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO 1 Go through the code comments, and make some notes :)

/**
 * @RestController: This annotation indicates that the class should be treated as a controller
 * that returns data directly to the client, typically in the form of JSON or XML. It's a
 * specialized version of the @Controller annotation which assumes @ResponseBody semantics
 * by default (i.e., the response object will be serialized directly to the response body).
 */
@RestController
public class PersonController {

    /**
     * @Autowired: This annotation allows Spring to automatically inject an instance of
     * PersonRepository into this bean. Spring will search for a matching bean in its
     * context (in this case, an instance of PersonRepository) and assign it to this field
     * when an instance of PersonController is created.
     */
    @Autowired
    private PersonRepository personRepository;

    /**
     * @GetMapping("/people"): This annotation is a specialized version of @RequestMapping
     * that acts as a shortcut for @RequestMapping(method = RequestMethod.GET). It indicates
     * that this method should handle GET requests to the "/people" URL path.
     */
    @GetMapping("/people")
    public List<Person> getAllPersons() {
        /**
         * Here, we call the 'findAll' method on our 'personRepository' bean.
         * This method is provided by the JpaRepository interface and retrieves
         * all records (of type Person) from the database.
         */
        return personRepository.findAll();
    }
}

/*
    TODO 2 Start your app and test the endpoint with Swagger

    You should get HTTP 200 and and empty array [] in the response body.
 */
