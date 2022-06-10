package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.DepartmentEntity;
import org.example.codefox.domainpole.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")

public interface DepartmentMapper extends AbstractMapper<DepartmentEntity, Department> {
    @Override
    DepartmentEntity toEntity(final Department dto);

    @Mapping(target = "id", source = "id")
    @Override
    Department toDto(final DepartmentEntity entity);

    @Override
    void update(Department dto, @MappingTarget DepartmentEntity updateEntity);
}
