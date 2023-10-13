package com.honca.hrms.controllers;

import com.honca.hrms.models.dto.EmployeeResponse;
import com.honca.hrms.models.dto.ProjectRequest;
import com.honca.hrms.models.dto.ProjectResponse;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.models.entities.Project;
import com.honca.hrms.services.interfaces.ProjectService;
import com.honca.hrms.services.mappers.EmployeeMapper;
import com.honca.hrms.services.mappers.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/add")
    public ResponseEntity<ProjectResponse> addProject(@RequestBody ProjectRequest projectRequest) {
        ProjectResponse addedProjectResponse = ProjectMapper.INSTANCE.projectToProjectResponse(projectService.addProject(projectRequest));
        return new ResponseEntity<>(addedProjectResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{projectId}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long projectId, @RequestBody ProjectRequest updatedProjectRequest) {
        ProjectResponse updatedProjectResponse = ProjectMapper.INSTANCE.projectToProjectResponse(projectService.updateProject(projectId, updatedProjectRequest));
        return new ResponseEntity<>(updatedProjectResponse, HttpStatus.OK);
    }

    @PutMapping("/addEmployee/{projectId}/{employeeId}")
    public ResponseEntity<ProjectResponse> addEmployee(@PathVariable Long projectId, @PathVariable Long employeeId) {
        Project foundProject = projectService.addEmployee(projectId, employeeId);
        ProjectResponse foundProjectResponse = ProjectMapper.INSTANCE.projectToProjectResponse(foundProject);
        return new ResponseEntity<>(foundProjectResponse, HttpStatus.OK);
    }

    @PutMapping("/removeEmployee/{projectId}/{employeeId}")
    public ResponseEntity<ProjectResponse> removeEmployee(@PathVariable Long projectId, @PathVariable Long employeeId) {
        Project foundProject = projectService.removeEmployee(projectId, employeeId);
        ProjectResponse foundProjectResponse = ProjectMapper.INSTANCE.projectToProjectResponse(foundProject);
        return new ResponseEntity<>(foundProjectResponse, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<ProjectResponse> foundProjectResponseList = ProjectMapper.INSTANCE.projectToProjectResponse(projectService.findAllProjects());
        return new ResponseEntity<>(foundProjectResponseList, HttpStatus.OK);
    }

    @GetMapping("/get/{projectId}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Long projectId) {
        ProjectResponse foundProject = ProjectMapper.INSTANCE.projectToProjectResponse(projectService.findProjectById(projectId));
        return new ResponseEntity<>(foundProject, HttpStatus.OK);
    }

    @GetMapping("/getEmployees/{projectId}")
    public ResponseEntity<List<EmployeeResponse>> getEmployees(@PathVariable Long projectId) {
        List<Employee> employeeList = projectService.getEmployees(projectId);
        List<EmployeeResponse> employeeResponseList = EmployeeMapper.INSTANCE.EmployeeResponseemployeeToEmployeeResponse(employeeList);
        return new ResponseEntity<>(employeeResponseList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        Project foundProject = projectService.findProjectById(projectId);
        projectService.deleteProject(foundProject);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
