package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Optional<Project> findProjectById(Long projectId);
    List<Project> findAllProjects();
    Project addProject(Project project);
    Project updateProject(Project updatedProject);
    void deleteProject(Long projectId);
}
