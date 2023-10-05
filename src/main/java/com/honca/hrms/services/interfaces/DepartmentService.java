package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse findDepartamentByName(String departmentName);
    List<DepartmentResponse> findAllDepartments();
    DepartmentResponse addDepartment(DepartmentRequest department);
    DepartmentResponse updateDepartament(DepartmentRequest updatedDepartment);
    void deleteDepartament(Long departamentId);
}
