package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.models.entities.Project;
import java.util.List;

public interface ProjectService {
    Project findProjectById(Long projectId);
    List<Project> findAllProjects();
    Project addProject(ProjectRequest newProjectRequest);
    Project updateProject(Long projectId, ProjectRequest updatedProjectRequest);
    Project addEmployee(Long projectId, Long employeeId);
    Project removeEmployee(Long projectId, Long employeeId);
    List<Employee> getEmployees(Long projectId);
    void deleteProject(Project project);
}
