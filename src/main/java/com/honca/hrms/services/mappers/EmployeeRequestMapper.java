package com.honca.hrms.services.mappers;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeRequestMapper {
    EmployeeRequestMapper INSTANCE = Mappers.getMapper(EmployeeRequestMapper.class);

    Employee mapToEmployee(EmployeeRequest employee);

}
