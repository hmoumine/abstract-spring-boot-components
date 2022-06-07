package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.entities.ZipCodeEntity;
import org.example.codefox.domainpole.model.ZipCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ZipCodeMapper {

    ZipCodeEntity toEntity(final ZipCode zipcodeDto);

    @Mapping(target = "id", source = "id")
    ZipCode toDto(final ZipCodeEntity zipcodeEntity);

}
