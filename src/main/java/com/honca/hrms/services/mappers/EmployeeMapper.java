package com.honca.hrms.services.mappers;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.dto.EmployeeResponse;
import com.honca.hrms.models.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeResponse employeeToEmployeeResponse(Employee employee);

    List<EmployeeResponse> EmployeeResponseemployeeToEmployeeResponse(List<Employee> employees);

    Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);
}
