package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.entities.Department;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.models.entities.Project;
import com.honca.hrms.repositories.DepartmentRepository;
import com.honca.hrms.repositories.EmployeeRepository;
import com.honca.hrms.repositories.ProjectRepository;
import com.honca.hrms.services.interfaces.EmployeeService;
import com.honca.hrms.services.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(EmployeeRequest newEmployeeRequest) {
        Employee newEmployee = EmployeeMapper.INSTANCE.employeeRequestToEmployee(newEmployeeRequest);
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Long employeeId, EmployeeRequest updatedEmployeeRequest) {
        Employee updatedEmployee = EmployeeMapper.INSTANCE.employeeRequestToEmployee(updatedEmployeeRequest);
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
        foundEmployee.setName(updatedEmployee.getName());
        foundEmployee.setSurname(updatedEmployee.getSurname());
        return employeeRepository.save(foundEmployee);
    }

    @Override
    public Employee updateDepartment(Long employeeId, Long departmentId) {
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
        Department foundDepartment = departmentRepository.findById(departmentId).orElseThrow(() -> new NoSuchElementException("Department could not be found"));
        if (foundEmployee.getDepartment() != null) {
            foundEmployee.getDepartment().getEmployees().remove(foundEmployee);
        }
        foundEmployee.setDepartment(foundDepartment);
        foundDepartment.getEmployees().add(foundEmployee);
        Employee savedEmployee = employeeRepository.save(foundEmployee);
        Department savedDepartment = departmentRepository.save(foundDepartment);
        return savedEmployee;
    }

    @Override
    public Employee removeDepartment(Long employeeId, Long departmentId) {
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
        Department foundDepartment = departmentRepository.findById(departmentId).orElseThrow(() -> new NoSuchElementException("Department could not be found"));
        foundEmployee.setDepartment(null);
        foundDepartment.getEmployees().remove(foundEmployee);
        Employee savedEmployee = employeeRepository.save(foundEmployee);
        Department savedDepartment = departmentRepository.save(foundDepartment);
        return savedEmployee;
    }

    @Override
    public Employee addProject(Long employeeId, Long projectId) {
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
        Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project could not be found"));
        foundEmployee.getProjects().add(foundProject);
        foundProject.getEmployees().add(foundEmployee);
        Employee savedEmployee = employeeRepository.save(foundEmployee);
        Project savedProject = projectRepository.save(foundProject);
        return savedEmployee;
    }

    @Override
    public Employee removeProject(Long employeeId, Long projectId) {
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
        Project foundProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project could not be found"));
        foundEmployee.getProjects().remove(foundProject);
        foundProject.getEmployees().remove(foundEmployee);
        Employee savedEmployee = employeeRepository.save(foundEmployee);
        Project savedProject = projectRepository.save(foundProject);
        return savedEmployee;
    }

    @Override
    public List<Project> getProjects(Long employeeId) {
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(()-> new NoSuchElementException("Employee could not be found"));
        return new ArrayList<>(foundEmployee.getProjects());
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
