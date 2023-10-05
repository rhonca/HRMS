package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse findDepartmentByName(String departmentName);
    List<DepartmentResponse> findAllDepartments();
    DepartmentResponse addDepartment(DepartmentRequest department);
    DepartmentResponse updateDepartment(DepartmentRequest updatedDepartment);
    void deleteDepartment(Long departmentId);
}
