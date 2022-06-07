package org.example.codefox.domainpole.mapper;


import org.example.codefox.domainpole.entities.PersonEntity;
import org.example.codefox.domainpole.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toDto(final PersonEntity personEntity);

    @Mapping(target = "id", source = "id")
    PersonEntity toEntity(final Person personDto);
}
