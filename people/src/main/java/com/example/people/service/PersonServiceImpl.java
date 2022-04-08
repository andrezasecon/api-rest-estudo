package com.example.people.service;

import com.example.people.model.Person;
import com.example.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository repository;

    @Override
    public Person getPersonById(Long id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPerson() {
        return repository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        repository.save(person);

    }

    @Override
    public void updatePerson(Long id, Person person) {
        Person p = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Person not found")
        );
        p.setName(person.getName());
        p.setEmail(person.getEmail());
        p.setCpf(person.getCpf());
        p.setEndereco(person.getEndereco());
        p.setTelefone(person.getTelefone());
        repository.save(p);
    }

    @Override
    public void deletePersonById(Long id) {
        Person p = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Person not found")
        );
        repository.deleteById(id);

    }

}
