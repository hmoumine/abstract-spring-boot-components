package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.OrganizationEntity;
import org.example.codefox.domainpole.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface OrganizationMapper extends AbstractMapper<OrganizationEntity, Organization> {
    @Override
    OrganizationEntity toEntity(final Organization dto);

    @Mapping(target = "id", source = "id")
    @Override
    Organization toDto(final OrganizationEntity entity);

    @Override
    void update(Organization dto, @MappingTarget OrganizationEntity updateEntity);
}
