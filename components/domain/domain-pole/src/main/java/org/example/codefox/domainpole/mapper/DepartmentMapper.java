package org.example.codefox.domainpole.mapper;

import org.example.codefox.domainpole.entities.DepartmentEntity;
import org.example.codefox.domainpole.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentEntity toEntity(final Department departmentDto);

    @Mapping(target = "id", source = "id")
    Department toDto(final DepartmentEntity departmentEntity);

}
