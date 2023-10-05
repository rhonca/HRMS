package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.entities.Department;
import com.honca.hrms.models.dto.DepartmentResponse;
import com.honca.hrms.services.mappers.DepartmentMapper;
import com.honca.hrms.services.mappers.DepartmentRequestMapper;
import com.honca.hrms.repositories.DepartmentRepositorie;
import com.honca.hrms.services.interfaces.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepositorie departmentRepositorie;

    public DepartmentServiceImpl(DepartmentRepositorie departmentRepositorie) {
        this.departmentRepositorie = departmentRepositorie;
    }

    @Override
    public DepartmentResponse findDepartamentByName(String departmentName) {
        return DepartmentMapper.INSTANCE.mapToDepartmentResponse(departmentRepositorie.findByName(departmentName));
    }

    @Override
    public List<DepartmentResponse> findAllDepartments() {
        return departmentRepositorie.findAll().stream().map(DepartmentMapper.INSTANCE::mapToDepartmentResponse).collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse addDepartment(DepartmentRequest department) {
        return DepartmentMapper.INSTANCE.mapToDepartmentResponse(departmentRepositorie.save(DepartmentRequestMapper.INSTANCE.mapToDepartment(department)));
    }

    @Override
    public DepartmentResponse updateDepartament(DepartmentRequest updatedDepartment) {
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
