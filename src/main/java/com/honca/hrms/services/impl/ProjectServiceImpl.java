package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.models.entities.Project;
import com.honca.hrms.repositories.EmployeeRepository;
import com.honca.hrms.repositories.ProjectRepository;
import com.honca.hrms.services.interfaces.ProjectService;
import com.honca.hrms.services.mappers.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project could not be found"));
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
        Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project could not be found"));
        foundProject.setName(updatedProject.getName());
        return projectRepository.save(foundProject);
    }

    @Override
    public Project addEmployee(Long projectId, Long employeeId) {
        Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project could not be found"));
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
        foundProject.getEmployees().add(foundEmployee);
        foundEmployee.getProjects().add(foundProject);
        Project savedProject = projectRepository.save(foundProject);
        Employee savedEmployee = employeeRepository.save(foundEmployee);
        return savedProject;
    }

    @Override
    public Project removeEmployee(Long projectId, Long employeeId) {
        Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project could not be found"));
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
        foundProject.getEmployees().remove(foundEmployee);
        foundEmployee.getProjects().remove(foundProject);
        Project savedProject = projectRepository.save(foundProject);
        Employee savedEmployee = employeeRepository.save(foundEmployee);
        return savedProject;
    }

    @Override
    public List<Employee> getEmployees(Long projectId) {
        Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project could not be found"));
        return new ArrayList<>(foundProject.getEmployees());
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }
}
