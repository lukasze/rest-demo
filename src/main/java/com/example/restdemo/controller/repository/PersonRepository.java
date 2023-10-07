package com.example.restdemo.controller.repository;

import com.example.restdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO 2 Read the below comment, and make some notes again :)
 *
 * The `public` keyword allows this interface to be accessible by other classes, regardless of their package.
 *
 * The `interface` keyword indicates that this is an interface in Java. An interface is a contract
 * that can be implemented by classes, ensuring those classes provide implementations for the methods
 * defined in the interface.
 *
 * `PersonRepository` is the name of our interface. By convention, the name suggests it acts as a
 * repository (or storage mechanism) for `Person` objects.
 *
 * The `extends` keyword here means that our `PersonRepository` inherits methods from another interface.
 *
 * `JpaRepository<Person, Long>` indicates that we're using Spring Data JPA's built-in JpaRepository interface:
 * - `Person` tells the repository that it's meant to handle `Person` objects.
 * - `Long` signifies that the ID (or unique identifier) for a `Person` is of type `Long`.
 *
 * Inside the curly braces `{ }`, we can define additional custom methods if needed. In this case, it's empty,
 * meaning we're only using the methods provided by JpaRepository without adding new ones.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}

// TODO 3: Checkout the next branch (7_glue-controller-with-repository)