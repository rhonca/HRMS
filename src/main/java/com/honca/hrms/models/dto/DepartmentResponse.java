package com.honca.hrms.models.dto;

import com.honca.hrms.models.entities.Employee;
import java.util.List;

public record DepartmentResponse(
        Long id,
        String name,
        List<Employee> employees
)
{}
