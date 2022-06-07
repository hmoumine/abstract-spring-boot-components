package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.model.City;
import org.example.codefox.domainpole.entities.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityEntity toEntity(final City cityDto);

    @Mapping(target = "id", source = "id")
    City toDto(final CityEntity cityEntity);


}


