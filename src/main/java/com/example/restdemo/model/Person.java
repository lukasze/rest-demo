package com.example.restdemo.model;

public class Person {

    private String name;
    private int age;
    private String address;

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
}

/*
    TODO 1: Readme

    Person class will represent the model in our application.

    Three steps to create this class:
    1. Generate the class usining IntelliJ
    2. Declare some private fields in the class
    3. Generate constructors, getters/setters

    Notice the Person class is within the model package.
    The packages in our application represent the application's layers, e.g., model, controller, repository, config.


 */

/*
    TODO 2: 5-minute discussion within your team (write down your thoughts/questions):

	Can you tell what is an object's:
	- state
	- behavior

	Can you point the code in the above class related to:
    - object's state
    - object's behavior
    - encapsulation?


 */


/*

 TODO 3: Readme
    The Big Picture

    Now that we have a model, we will use it to achieve the following:


    1. The Client sends a data request to the Spring Boot App.
    2. The Spring Boot App sends a request to fetch the data from the Relational Database.
    3. The Relational Database returns the data.
    4. Within the Spring Boot App, the data (row) is converted into a Java Person object.
    5. The Java Person object is then converted to its JSON representation.
    6. The Spring Boot App sends back the JSON representation of the Person to the Client.

 Client          Spring Boot App                     Relational Database
  |                   |                                      |
  |  Request data     |                                      |
  |------------------>|                                      |
  |                   | Fetch data from DB                   |
  |                   |------------------------------------->|
  |                   |                                      |
  |                   | Return row data                      |
  |                   |<-------------------------------------|
  |                   | Convert row to Java Object (Person)  |
  |                   | Convert Java Object to JSON          |
  |                   |                                      |
  | Return JSON       |                                      |
  |<------------------|                                      |
  |                   |                                      |

 */

/*
    TODO 4: Checkout the next branch (3_create-controller-and-test-it-with-swagger)
 */