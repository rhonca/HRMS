package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.entities.Department;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.repositories.DepartmentRepository;
import com.honca.hrms.repositories.EmployeeRepository;
import com.honca.hrms.services.interfaces.DepartmentService;
import com.honca.hrms.services.mappers.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Department findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new NoSuchElementException("Department could not be found"));
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department createDepartment(DepartmentRequest newDepartmentRequest) {
        Department newDepartment = DepartmentMapper.INSTANCE.departmentRequestToDepartment(newDepartmentRequest);
        return departmentRepository.save(newDepartment);
    }

    @Override
    public Department updateDepartment(Long departmentId, DepartmentRequest updatedDepartmentRequest) {
        Department updatedDepartment = DepartmentMapper.INSTANCE.departmentRequestToDepartment(updatedDepartmentRequest);
        Department foundDepartment = departmentRepository.findById(departmentId).orElseThrow(() -> new NoSuchElementException("Department could not be found"));
        foundDepartment.setName(updatedDepartment.getName());
        return departmentRepository.save(foundDepartment);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    public Department addEmployee(Long departmentId, Long employeeId) {
        Department foundDepartment = departmentRepository.findById(departmentId).orElseThrow(() -> new NoSuchElementException("Department could not be found"));
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));

        foundEmployee.setDepartment(foundDepartment);
        foundDepartment.getEmployees().add(foundEmployee);
        Department savedDepartment = departmentRepository.save(foundDepartment);
        Employee savedEmployee = employeeRepository.save(foundEmployee);

        return savedDepartment;
    }

    @Override
    public Department removeEmployee(Long departmentId, Long employeeId) {
        Department foundDepartment = departmentRepository.findById(departmentId).orElseThrow(() -> new NoSuchElementException("Department could not be found"));
        Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));

        if (!foundDepartment.getEmployees().contains(foundEmployee)) {
            throw new NoSuchElementException("Employee could not be found");
        }
        foundDepartment.getEmployees().remove(foundEmployee);
        foundEmployee.setDepartment(null);
        Department savedDepartment =  departmentRepository.save(foundDepartment);
        Employee savedEmployee =  employeeRepository.save(foundEmployee);
        return savedDepartment;
    }

    @Override
    public List<Employee> findAllEmployees(Long departmentId) {
        Department fondDepartment = departmentRepository.findById(departmentId).orElseThrow(()-> new NoSuchElementException("Department could not be found"));
        return new ArrayList<>(fondDepartment.getEmployees());
    }
}
