package com.honca.hrms.services.mappers;

import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.dto.ProjectResponse;
import com.honca.hrms.models.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    ProjectResponse projectToProjectResponse(Project project);
    List<ProjectResponse> projectToProjectResponse(List<Project> projects);
    Project projectRequestToProject(ProjectRequest projectRequest);
}
