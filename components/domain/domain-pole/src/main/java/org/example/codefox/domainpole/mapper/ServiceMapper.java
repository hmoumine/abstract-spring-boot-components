package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.ServiceEntity;
import org.example.codefox.domainpole.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface ServiceMapper extends AbstractMapper<ServiceEntity, Service> {
    @Override
    ServiceEntity toEntity(final Service dto);

    @Mapping(target = "id", source = "id")
    @Override
    Service toDto(final ServiceEntity entity);

    @Override
    void update(Service dto, @MappingTarget ServiceEntity updateEntity);
}
