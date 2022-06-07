package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.entities.OrganizationEntity;
import org.example.codefox.domainpole.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationEntity toEntity(final Organization organizationDto);

    @Mapping(target = "id", source = "id")
    Organization toDto(final OrganizationEntity organizationEntity);

}
