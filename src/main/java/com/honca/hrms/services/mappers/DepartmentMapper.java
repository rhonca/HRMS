package com.honca.hrms.services.mappers;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.dto.DepartmentResponse;
import com.honca.hrms.models.entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentResponse departmentToDepartmentResponse(Department department);

    List<DepartmentResponse> departmentToDepartmentResponse(List<Department> departments);

    Department departmentRequestToDepartment(DepartmentRequest departmentRequest);
}
