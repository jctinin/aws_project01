package com.aws_project01.aws_project01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws_project01.aws_project01.entity.Dog;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectController.class);

    @GetMapping("/dog/{name}")
    public ResponseEntity<?> getDog(@PathVariable String name) {
        LOG.info("Received request for dog with name: {}", name);

        String response = "Dog name is: " + name;
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<String> getTestApi(){
        LOG.info("Test API called");
        return ResponseEntity.ok("Test API is working");
    }

    @PostMapping("/dog")
    public ResponseEntity<Dog> createDog(@RequestBody Dog dogData) {
        Dog dog = new Dog(dogData.getName(), dogData.getBreed());
        LOG.info("Creating dog with name: {}, and breed: {}", dogData.getName(), dogData.getBreed());

        // Here you would typically save the dog to a database
        return ResponseEntity.ok(dog);

    }
}
