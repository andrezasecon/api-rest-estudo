package com.example.people.service;

import com.example.people.dto.PersonDto;
import com.example.people.model.Person;

import java.util.List;

public interface PersonService {

    PersonDto getPersonById(Long id);
    List<Person> getAllPerson();
    void savePerson(PersonDto person);
    void updatePerson(Long id, PersonDto person);
    void deletePersonById(Long id);





}
