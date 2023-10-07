package com.example.restdemo.controller;

import com.example.restdemo.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// This annotation specifies that we're testing only the MVC components of the PersonController
@WebMvcTest(PersonController.class)
public class PersonControllerObjectMapperTest {

    // MockMvc provides a way to test Spring MVC controllers by sending HTTP requests into the DispatcherServlet 
    // and asserting the response details.
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper provides functionality to convert between Java objects and their JSON representation.
    @Autowired
    private ObjectMapper objectMapper;

    // Before each test method is run, this setup method will be invoked. 
    // As of now, it's empty, but you can add any initial setup for your tests here.
    @BeforeEach
    public void setup() {}

    // The Test annotation indicates that this method is a test method.
    @Test
    public void testGetAllPeople() throws Exception {
        // Setting up the expected list of Person objects which the controller should return.
        List<Person> expectedPeople = List.of(
                new Person("John Doe", 30, "123 Main St"),
                new Person("Jane Smith", 25, "456 Maple Ave"),
                new Person("Bill Gates", 65, "789 Elm St")
        );

        // Converting the expected list of people to a JSON string.
        String expectedJsonResponse = objectMapper.writeValueAsString(expectedPeople);

        // Using mockMvc to perform an HTTP GET request to /people
        mockMvc.perform(get("/people"))
                // Expecting the HTTP status to be 200 OK
                .andExpect(status().isOk())
                // Expecting the response body to be the JSON representation of the expected list of people.
                .andExpect(content().json(expectedJsonResponse));
    }
}

/*
        TODO 1: MockMvc Tests

        Read the comments in this class
        Write down any questions/comments.

       TODO 2: Checkout the next branch (5_add-db-dependencies)
 */
