package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.entities.PoleEntity;
import org.example.codefox.domainpole.model.Pole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PoleMapper {

    PoleEntity toEntity(final Pole poleDto);

    @Mapping(target = "id", source = "id")
    Pole toDto(final PoleEntity poleEntity);

    void update(@MappingTarget PoleEntity entity, PoleEntity updateEntity);


}
