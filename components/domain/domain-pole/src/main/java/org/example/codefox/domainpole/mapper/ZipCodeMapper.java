package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.ZipCodeEntity;
import org.example.codefox.domainpole.model.ZipCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface ZipCodeMapper extends AbstractMapper<ZipCodeEntity, ZipCode> {
    @Override
    ZipCodeEntity toEntity(final ZipCode dto);

    @Mapping(target = "id", source = "id")
    @Override
    ZipCode toDto(final ZipCodeEntity entity);

    @Override
    void update(ZipCode dto, @MappingTarget ZipCodeEntity updateEntity);
}
