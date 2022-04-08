package com.example.people.exceptions.service.impl;

import com.example.people.exceptions.NotFoundException;
import com.example.people.model.Person;
import com.example.people.repository.PersonRepository;
import com.example.people.exceptions.service.PersonService;
import com.example.people.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MessageUtil messageUtil;

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
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
                () -> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
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
                () -> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
        );
        personRepository.deleteById(id);

    }

}
