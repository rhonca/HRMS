package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.entities.Department;
import com.honca.hrms.repositories.DepartmentRepository;
import com.honca.hrms.services.interfaces.DepartmentService;
import com.honca.hrms.services.mappers.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new NoSuchElementException("Department could not be found"));
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addDepartment(DepartmentRequest newDepartmentRequest) {
        Department newDepartment = DepartmentMapper.INSTANCE.departmentRequestToDepartment(newDepartmentRequest);
        return departmentRepository.save(newDepartment);
    }

    @Override
    public Department updateDepartment(Long departmentId, DepartmentRequest updatedDepartmentRequest) {
        Department updatedDepartment = DepartmentMapper.INSTANCE.departmentRequestToDepartment(updatedDepartmentRequest);
        Department savedDepartment = null;
        if (departmentRepository.existsById(departmentId)) {
            savedDepartment = departmentRepository.save(updatedDepartment);
        }
        return savedDepartment;
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }
}
