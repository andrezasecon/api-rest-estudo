package com.example.people.service.impl;

import com.example.people.dto.PersonDto;
import com.example.people.exceptions.NotFoundException;
import com.example.people.mapper.PersonMapper;
import com.example.people.model.Person;
import com.example.people.repository.PersonRepository;
import com.example.people.service.PersonService;
import com.example.people.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDto getPersonById(Long id) {
        return personMapper.toDto(personRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
        ));
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);
        personRepository.save(person);

    }

    @Override
    public void updatePerson(Long id, PersonDto personDto) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
        );
        personMapper.updateEntity(personDto, person);
        personRepository.save(person);
    }

    @Override
    public void deletePersonById(Long id) {
        Person p = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
        );
        personRepository.deleteById(id);

    }

}
