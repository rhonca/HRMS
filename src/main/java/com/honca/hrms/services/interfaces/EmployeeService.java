package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findEmployeeById(Long employeeId);
    List<Employee> findAllEmployees();
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee updatedEmployee);
    void deleteEmployee(Long employeeId);

}
