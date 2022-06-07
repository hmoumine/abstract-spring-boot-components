package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.entities.GroupEntity;
import org.example.codefox.domainpole.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    GroupEntity toEntity(final Group groupDto);

    @Mapping(target = "id", source = "id")
    Group toDto(final GroupEntity groupEntity);
}

