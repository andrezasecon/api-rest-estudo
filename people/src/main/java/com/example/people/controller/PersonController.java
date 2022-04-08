package com.example.people.controller;

import com.example.people.model.Person;
import com.example.people.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    private Map<String, Object> response = new HashMap<>();

    @GetMapping("/all")
    public ResponseEntity<?> findAllPerson(){
        response.clear();
        response.put("people", service.getAllPerson());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getPersonById(@PathVariable Long id){
        response.clear();
        response.put("person", service.getPersonById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new")
    private ResponseEntity<?> savePerson(@RequestBody Person person){
        response.clear();
        service.savePerson(person);
        response.put("Message", "Save person successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody Person person){
        response.clear();
        service.getPersonById(id);
        service.savePerson(person);
        response.put("message", "Person update successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePersonById(@PathVariable Long id){
        response.clear();;
        service.deletePersonById(id);
        response.put("message", "Person deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
