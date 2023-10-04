package com.honca.hrms.services.impl;

import com.honca.hrms.models.Employee;
import com.honca.hrms.repositories.EmployeeRepositorie;
import com.honca.hrms.services.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositorie employeeRepositorie;

    public EmployeeServiceImpl(EmployeeRepositorie employeeRepositorie) {
        this.employeeRepositorie = employeeRepositorie;
    }

    @Override
    public Optional<Employee> findEmployeeById(Long employeeId) {
        return employeeRepositorie.findById(employeeId);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepositorie.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepositorie.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee updatedEmployee) {
        //TO DO add method code
        return null;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee foundEmployee = employeeRepositorie.findById(employeeId).get();
        //TO DO exception handling
        employeeRepositorie.delete(foundEmployee);
    }
}
