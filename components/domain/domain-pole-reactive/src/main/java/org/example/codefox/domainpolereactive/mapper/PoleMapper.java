package org.example.codefox.domainpolereactive.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpolereactive.entities.PoleEntity;
import org.example.codefox.domainpolereactive.model.Pole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface PoleMapper extends AbstractMapper<PoleEntity, Pole> {
    @Override
    PoleEntity toEntity(final Pole dto);

    @Mapping(target = "id", source = "id")
    @Override
    Pole toDto(final PoleEntity entity);

    @Override
    void update(Pole dto, @MappingTarget PoleEntity updateEntity);
}
