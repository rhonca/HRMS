package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.dto.EmployeeResponse;
import com.honca.hrms.models.entities.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeResponse findEmployeeById(Long employeeId);
    List<EmployeeResponse> findAllEmployees();
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);
    Employee updateEmployee(Employee updatedEmployee);
    void deleteEmployee(Long employeeId);

}
