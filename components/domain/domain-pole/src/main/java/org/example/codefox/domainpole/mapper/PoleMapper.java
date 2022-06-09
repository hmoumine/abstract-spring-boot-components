package org.example.codefox.domainpole.mapper;

import org.example.codefox.domaincommons.mapper.AbstractMapper;
import org.example.codefox.domainpole.entities.PoleEntity;
import org.example.codefox.domainpole.model.Pole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PoleMapper extends AbstractMapper<PoleEntity, Pole> {

}
