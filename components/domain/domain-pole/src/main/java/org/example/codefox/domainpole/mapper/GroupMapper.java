package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.GroupEntity;
import org.example.codefox.domainpole.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface GroupMapper extends AbstractMapper<GroupEntity, Group> {
    @Override
    GroupEntity toEntity(final Group dto);

    @Mapping(target = "id", source = "id")
    @Override
    Group toDto(final GroupEntity entity);

    @Override
    void update(Group dto, @MappingTarget GroupEntity updateEntity);
}

