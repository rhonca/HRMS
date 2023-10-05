package com.honca.hrms.services.impl;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.dto.EmployeeResponse;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.repositories.EmployeeRepositorie;
import com.honca.hrms.services.interfaces.EmployeeService;
import com.honca.hrms.services.mappers.EmployeeMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositorie employeeRepositorie;

    public EmployeeServiceImpl(EmployeeRepositorie employeeRepositorie) {
        this.employeeRepositorie = employeeRepositorie;
    }

    @Override
    public EmployeeResponse findEmployeeById(Long employeeId) {
        return EmployeeMapper.INSTANCE.employeeToEmployeeResponse(employeeRepositorie.findById(employeeId).get());
        //TO DO exception handling
    }

    @Override
    public List<EmployeeResponse> findAllEmployees() {
        return employeeRepositorie.findAll()
                .stream()
                .map(EmployeeMapper.INSTANCE::employeeToEmployeeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        return EmployeeMapper.INSTANCE
                .employeeToEmployeeResponse(employeeRepositorie
                        .save(EmployeeMapper.INSTANCE.employeeRequestToEmployee(employeeRequest)));
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
