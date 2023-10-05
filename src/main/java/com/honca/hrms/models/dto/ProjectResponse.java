package com.honca.hrms.models.dto;

import com.honca.hrms.models.entities.Employee;
import java.util.Set;

public record ProjectResponse(
        Long id,
        String name,
        Set<Employee> employees
) {
}
