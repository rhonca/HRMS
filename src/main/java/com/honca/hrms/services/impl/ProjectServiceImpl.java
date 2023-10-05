package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.dto.ProjectResponse;
import com.honca.hrms.models.entities.Project;
import com.honca.hrms.repositories.ProjectRepositorie;
import com.honca.hrms.services.interfaces.ProjectService;
import com.honca.hrms.services.mappers.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepositorie projectRepositorie;

    public ProjectServiceImpl(ProjectRepositorie projectRepositorie) {
        this.projectRepositorie = projectRepositorie;
    }

    @Override
    public ProjectResponse findProjectById(Long projectId) {
        return ProjectMapper.INSTANCE.projectToProjectResponse(projectRepositorie.findById(projectId).get());
    }

    @Override
    public List<ProjectResponse> findAllProjects() {
        return projectRepositorie.findAll()
                .stream()
                .map(ProjectMapper.INSTANCE::projectToProjectResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse addProject(ProjectRequest projectRequest) {
        return ProjectMapper.INSTANCE.
                projectToProjectResponse(projectRepositorie
                        .save(ProjectMapper.INSTANCE.projectRequestToProject(projectRequest)));
    }

    @Override
    public ProjectResponse updateProject(ProjectRequest updatedProject) {
        //TO DO method code
        return null;
    }

    @Override
    public void deleteProject(Long projectId) {
        Project foundProject = projectRepositorie.findById(projectId).get();
        //TO DO exception handling
        projectRepositorie.delete(foundProject);
    }
}
