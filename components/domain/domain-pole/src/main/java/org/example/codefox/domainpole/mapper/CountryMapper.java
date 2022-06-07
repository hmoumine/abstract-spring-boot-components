package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.entities.CountryEntity;
import org.example.codefox.domainpole.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryEntity toEntity(final Country countryDto);

    @Mapping(target = "id", source = "id")
    Country toDto(final CountryEntity countryEntity);

}
