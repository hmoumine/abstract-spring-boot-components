package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.ZipCodeEntity;
import org.example.codefox.domainpole.model.ZipCode;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ZipCodeMapper extends AbstractMapper<ZipCodeEntity, ZipCode> {

}
