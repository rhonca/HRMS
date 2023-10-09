package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.repositories.EmployeeRepository;
import com.honca.hrms.services.interfaces.EmployeeService;
import com.honca.hrms.services.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee could not be found"));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(EmployeeRequest newEmployeeRequest) {
        Employee newEmployee = EmployeeMapper.INSTANCE.employeeRequestToEmployee(newEmployeeRequest);
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Long employeeId, EmployeeRequest updatedEmployeeRequest) {
        Employee updatedEmployee = EmployeeMapper.INSTANCE.employeeRequestToEmployee(updatedEmployeeRequest);
        Employee savedEmployee = null;
        if (employeeRepository.existsById(employeeId)) {
            savedEmployee = employeeRepository.save(updatedEmployee);
        }
        return savedEmployee;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        //TO DO exception handling
        employeeRepository.delete(employee);
    }
}
