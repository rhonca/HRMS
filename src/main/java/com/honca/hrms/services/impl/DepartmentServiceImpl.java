package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.entities.Department;
import com.honca.hrms.models.dto.DepartmentResponse;
import com.honca.hrms.services.mappers.DepartmentMapper;
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
    public DepartmentResponse findDepartmentByName(String departmentName) {
        return DepartmentMapper.INSTANCE.departmentToDepartmentResponse(departmentRepositorie.findByName(departmentName));
    }

    @Override
    public List<DepartmentResponse> findAllDepartments() {
        //TO DO make list mapper
        return departmentRepositorie.findAll().stream().map(DepartmentMapper.INSTANCE::departmentToDepartmentResponse).collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse addDepartment(DepartmentRequest department) {
        return DepartmentMapper.INSTANCE.departmentToDepartmentResponse(departmentRepositorie.save(DepartmentMapper.INSTANCE.departmentRequestToDepartment(department)));
    }

    @Override
    public DepartmentResponse updateDepartment(DepartmentRequest updatedDepartment) {
        //TO DO method code
        return null;
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department foundDepartment = departmentRepositorie.findById(departmentId).get();
        //TO DO exception handling
        departmentRepositorie.delete(foundDepartment);
    }
}
