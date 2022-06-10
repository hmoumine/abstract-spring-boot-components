package org.example.codefox.domainpole.mapper;


import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.PersonEntity;
import org.example.codefox.domainpole.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface PersonMapper extends AbstractMapper<PersonEntity, Person> {
    @Override
    PersonEntity toEntity(final Person dto);

    @Mapping(target = "id", source = "id")
    @Override
    Person toDto(final PersonEntity entity);

    @Override
    void update(Person dto, @MappingTarget PersonEntity updateEntity);
}
