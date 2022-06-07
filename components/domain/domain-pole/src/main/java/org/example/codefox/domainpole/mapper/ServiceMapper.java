package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.entities.ServiceEntity;
import org.example.codefox.domainpole.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ServiceEntity toEntity(final Service serviceDto);

    @Mapping(target = "id", source = "id")
    Service toDto(final ServiceEntity serviceEntity);

}
