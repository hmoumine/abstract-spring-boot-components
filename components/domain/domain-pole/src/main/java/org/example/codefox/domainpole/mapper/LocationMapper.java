package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.LocationEntity;
import org.example.codefox.domainpole.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface LocationMapper extends AbstractMapper<LocationEntity, Location> {
    @Override
    LocationEntity toEntity(final Location dto);

    @Mapping(target = "id", source = "id")
    @Override
    Location toDto(final LocationEntity entity);

    @Override
    void update(Location dto, @MappingTarget LocationEntity updateEntity);
}
