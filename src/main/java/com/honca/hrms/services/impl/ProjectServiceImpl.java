package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.entities.Project;
import com.honca.hrms.repositories.ProjectRepository;
import com.honca.hrms.services.interfaces.ProjectService;
import com.honca.hrms.services.mappers.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElseThrow(()-> new NoSuchElementException("Project could not be found"));
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project addProject(ProjectRequest newProjectRequest) {
        Project newProject = ProjectMapper.INSTANCE.projectRequestToProject(newProjectRequest);
        return projectRepository.save(newProject);
    }

    @Override
    public Project updateProject(Long projectId, ProjectRequest updatedProjectRequest) {
        Project updatedProject = ProjectMapper.INSTANCE.projectRequestToProject(updatedProjectRequest);
        Project savedProject = null;
        if (projectRepository.existsById(projectId)) {
            savedProject = projectRepository.save(updatedProject);
        }
        return savedProject;
    }

    @Override
    public void deleteProject(Project project) {
        //TO DO exception handling
        projectRepository.delete(project);
    }
}
