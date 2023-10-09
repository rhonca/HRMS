package com.honca.hrms.services.interfaces;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.entities.Employee;
import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(Long employeeId);
    List<Employee> findAllEmployees();
    Employee addEmployee(EmployeeRequest newEmployeeRequest);
    Employee updateEmployee(Long employeeId, EmployeeRequest updatedEmployeeRequest);
    void deleteEmployee(Employee employee);

}
