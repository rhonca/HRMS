package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.dto.ProjectResponse;
import com.honca.hrms.models.entities.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    ProjectResponse findProjectById(Long projectId);
    List<ProjectResponse> findAllProjects();
    ProjectResponse addProject(ProjectRequest project);
    ProjectResponse updateProject(ProjectRequest updatedProject);
    void deleteProject(Long projectId);
}
