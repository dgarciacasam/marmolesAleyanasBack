package com.marmolesAleyanas.marmolesAleyanasBack.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.marmolesAleyanas.marmolesAleyanasBack.dto.ProjectDTO;
import com.marmolesAleyanas.marmolesAleyanasBack.models.ProjectModel;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProjectMapper {
     ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    void updateProjectFromDto(ProjectDTO dto, @MappingTarget ProjectModel entity);
}
