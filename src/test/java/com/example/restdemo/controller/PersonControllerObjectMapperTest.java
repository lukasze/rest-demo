package com.example.restdemo.controller;

import com.example.restdemo.model.Person;
import com.example.restdemo.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerObjectMapperTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    List<Person> expectedPeople = List.of(
            new Person("John Doe", 30, "123 Main St"),
            new Person("Jane Smith", 25, "456 Maple Ave"),
            new Person("Bill Gates", 65, "789 Elm St")
    );

    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    public void setup() {}

    @Test
    public void testGetAllPeople() throws Exception {
        personRepository.saveAll(expectedPeople);

        String expectedJsonResponse = objectMapper.writeValueAsString(expectedPeople);

        mockMvc.perform(get("/people"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }


    /*
        TODO 3 Run all the tests
        TODO 4 Delete @DirtiesContext from the test and rerun all tests
          -can you explain what happened?
     */
    @Test
    @DirtiesContext
    public void testSavePerson() throws Exception {
        Person newPerson = new Person("Tom Cruise", 58, "Hollywood St");
        String newPersonJsonRequest = objectMapper.writeValueAsString(newPerson);

        // Expecting the returned JSON to be the same as newPerson but with an ID of 1
        Person expectedPersonWithId = new Person("Tom Cruise", 58, "Hollywood St");
        expectedPersonWithId.setId(1L);
        String expectedJsonResponse = objectMapper.writeValueAsString(expectedPersonWithId);

        mockMvc.perform(post("/people")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newPersonJsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResponse));
    }
}
