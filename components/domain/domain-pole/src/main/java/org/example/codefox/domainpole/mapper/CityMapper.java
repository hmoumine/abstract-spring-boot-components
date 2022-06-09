package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.CityEntity;
import org.example.codefox.domainpole.model.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper extends AbstractMapper<CityEntity, City> {

}


