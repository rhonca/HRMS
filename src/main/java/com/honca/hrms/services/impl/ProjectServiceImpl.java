package com.honca.hrms.services.impl;

import com.honca.hrms.models.Project;
import com.honca.hrms.repositories.ProjectRepositorie;
import com.honca.hrms.services.interfaces.ProjectService;
import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepositorie projectRepositorie;

    public ProjectServiceImpl(ProjectRepositorie projectRepositorie) {
        this.projectRepositorie = projectRepositorie;
    }

    @Override
    public Optional<Project> findProjectById(Long projectId) {
        return projectRepositorie.findById(projectId);
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepositorie.findAll();
    }

    @Override
    public Project addProject(Project project) {
        return projectRepositorie.save(project);
    }

    @Override
    public Project updateProject(Project updatedProject) {
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
