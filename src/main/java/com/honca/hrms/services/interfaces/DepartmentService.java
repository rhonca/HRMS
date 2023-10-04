package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.Department;
import java.util.List;

public interface DepartmentService {
    Department findDepartamentByName(String departmentName);
    List<Department> findAllDepartaments();
    Department addDepartament(Department department);
    Department updateDepartament(Department updatedDepartment);
    void deleteDepartament(Long departamentId);
}
