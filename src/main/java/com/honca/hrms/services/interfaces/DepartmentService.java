package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department findDepartmentById(Long departmentId);
    List<Department> findAllDepartments();
    Department addDepartment(DepartmentRequest newDepartmentRequest);
    Department updateDepartment(Long departmentId, DepartmentRequest updatedDepartmentRequest);
    void deleteDepartment(Department department);
}
