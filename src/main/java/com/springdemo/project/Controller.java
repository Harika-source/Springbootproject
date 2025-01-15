package com.springdemo.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Dog dog;

    @GetMapping("/person1")
    public Person getPerson1(){
        Person p = new Person("Vaishu", 222);
        return p;
    }

    @GetMapping("/person2")
    public Person getPerson2() {
        Person p = new Person("Harika", 123);
        return p;
    }

    @GetMapping("/dog")
    public String getDog(){

        return dog.bark();

    }

}
