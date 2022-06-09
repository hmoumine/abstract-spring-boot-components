package org.example.codefox.domainpole.mapper;


import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.PersonEntity;
import org.example.codefox.domainpole.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends AbstractMapper<PersonEntity, Person> {

}
