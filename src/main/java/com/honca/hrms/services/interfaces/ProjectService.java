package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.entities.Project;
import java.util.List;

public interface ProjectService {
    Project findProjectById(Long projectId);
    List<Project> findAllProjects();
    Project addProject(ProjectRequest newProjectRequest);
    Project updateProject(Long projectId, ProjectRequest updatedProjectRequest);
    void deleteProject(Project project);
}
