package com.honca.hrms.services.mappers;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentRequestMapper {
    DepartmentRequestMapper INSTANCE = Mappers.getMapper( DepartmentRequestMapper.class );
    Department mapToDepartment(DepartmentRequest departmentRequest);
}
