package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.models.entities.Project;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(Long employeeId);

    List<Employee> findAllEmployees();

    Employee addEmployee(EmployeeRequest newEmployeeRequest);

    Employee updateEmployee(Long employeeId, EmployeeRequest updatedEmployeeRequest);

    Employee updateDepartment(Long employeeId, Long departmentId);

    Employee removeDepartment(Long employeeId, Long departmentId);

    Employee addProject(Long employeeId, Long projectId);

    Employee removeProject(Long employeeId, Long projectId);
    List<Project> getProjects(Long employeeId);

    void deleteEmployee(Employee employee);


}
