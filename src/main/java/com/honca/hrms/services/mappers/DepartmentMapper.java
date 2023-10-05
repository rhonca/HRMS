package com.honca.hrms.services.mappers;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.dto.DepartmentResponse;
import com.honca.hrms.models.entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentResponse departmentToDepartmentResponse(Department department);
    Department departmentRequestToDepartment(DepartmentRequest departmentRequest);
}
