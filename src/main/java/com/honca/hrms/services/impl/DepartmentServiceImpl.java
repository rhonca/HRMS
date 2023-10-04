package com.honca.hrms.services.impl;

import com.honca.hrms.models.Department;
import com.honca.hrms.repositories.DepartmentRepositorie;
import com.honca.hrms.services.interfaces.DepartmentService;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepositorie departmentRepositorie;

    public DepartmentServiceImpl(DepartmentRepositorie departmentRepositorie) {
        this.departmentRepositorie = departmentRepositorie;
    }

    @Override
    public Department findDepartamentByName(String departmentName) {
        return departmentRepositorie.findByName(departmentName);
    }

    @Override
    public List<Department> findAllDepartaments() {
        return departmentRepositorie.findAll();
    }

    @Override
    public Department addDepartament(Department department) {
        return departmentRepositorie.save(department);
    }

    @Override
    public Department updateDepartament(Department updatedDepartment) {
        //TO DO method code
        return null;
    }

    @Override
    public void deleteDepartament(Long departamentId) {
        Department foundDepartment = departmentRepositorie.findById(departamentId).get();
        //TO DO exception handling
        departmentRepositorie.delete(foundDepartment);
    }
}
