package com.example.people.mapper;

import com.example.people.dto.PersonDto;
import com.example.people.model.Person;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toEntity(PersonDto personDto);
    PersonDto toDto(Person person);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(PersonDto personDto, @MappingTarget Person person);
}
