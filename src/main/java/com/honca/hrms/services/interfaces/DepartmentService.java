package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.entities.Department;
import com.honca.hrms.models.entities.Employee;

import java.util.List;

public interface DepartmentService {
    Department findDepartmentById(Long departmentId);
    List<Department> findAllDepartments();
    Department createDepartment(DepartmentRequest newDepartmentRequest);
    Department updateDepartment(Long departmentId, DepartmentRequest updatedDepartmentRequest);
    void deleteDepartment(Department department);
    Department addEmployee(Long departmentId, Long employeeId);
    Department removeEmployee(Long departmentId, Long employeeId);
    List<Employee> findAllEmployees(Long departmentId);

}
