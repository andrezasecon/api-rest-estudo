package com.example.people.controller;

import com.example.people.model.Person;
import com.example.people.exceptions.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    private Map<String, Object> response = new HashMap<>();

    @GetMapping("/all")
    public ResponseEntity<?> findAllPerson(){
        response.clear();
        response.put("people", personService.getAllPerson());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getPersonById(@PathVariable Long id){
        response.clear();
        response.put("person", personService.getPersonById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new")
    private ResponseEntity<?> savePerson(@Valid @RequestBody Person person){
        response.clear();
        personService.savePerson(person);
        response.put("Message", "Save person successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody Person person){
        response.clear();
        personService.updatePerson(id, person);
        response.put("message", "Person update successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePersonById(@PathVariable Long id){
        response.clear();;
        personService.deletePersonById(id);
        response.put("message", "Person deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
