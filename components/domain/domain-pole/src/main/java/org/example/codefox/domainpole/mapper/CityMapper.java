package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.CityEntity;
import org.example.codefox.domainpole.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CityMapper extends AbstractMapper<CityEntity, City> {
    @Override
    CityEntity toEntity(final City dto);

    @Mapping(target = "id", source = "id")
    @Override
    City toDto(final CityEntity entity);

    @Override
    void update(City dto, @MappingTarget CityEntity updateEntity);
}


