package com.honca.hrms.models.dto;

import com.honca.hrms.models.entities.Department;
import com.honca.hrms.models.entities.Project;
import java.util.Set;

public record EmployeeRequest(
        String name,
        String surname,
        Department department,
        Set<Project> projects
) {
}
