package com.honca.hrms.services.mappers;

import com.honca.hrms.models.dto.ProjectResponse;
import com.honca.hrms.models.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectResponse mapToProjectResponse(Project project);
}
