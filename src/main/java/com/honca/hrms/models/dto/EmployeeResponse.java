package com.honca.hrms.models.dto;

import com.honca.hrms.models.entities.Department;

public record EmployeeResponse(
        Long id,
        String name,
        String surname,
        Department department
) {
}
