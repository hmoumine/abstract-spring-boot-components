package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.CountryEntity;
import org.example.codefox.domainpole.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface CountryMapper extends AbstractMapper<CountryEntity, Country> {
    @Override
    CountryEntity toEntity(final Country dto);

    @Mapping(target = "id", source = "id")
    @Override
    Country toDto(final CountryEntity entity);

    @Override
    void update(Country dto, @MappingTarget CountryEntity updateEntity);
}
