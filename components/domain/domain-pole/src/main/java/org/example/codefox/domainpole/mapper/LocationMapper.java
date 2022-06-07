package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.model.Location;
import org.example.codefox.domainpole.entities.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationEntity toEntity(final Location locationDto);

    @Mapping(target = "id", source = "locationEntity.id")
    Location toDto(final LocationEntity locationEntity);

}
