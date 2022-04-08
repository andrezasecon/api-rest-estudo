package com.example.people.service;

import com.example.people.exceptions.NotFoundException;
import com.example.people.model.Person;
import com.example.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPersonById(Long id) {

        return personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person not found")
        );
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);

    }

    @Override
    public void updatePerson(Long id, Person person) {
        Person p = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person not found")
        );
        p.setName(person.getName());
        p.setEmail(person.getEmail());
        p.setCpf(person.getCpf());
        p.setAddress(person.getAddress());
        p.setPhone(person.getPhone());
        personRepository.save(p);
    }

    @Override
    public void deletePersonById(Long id) {
        Person p = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person not found")
        );
        personRepository.deleteById(id);

    }

}
