package com.honca.hrms.repositories;

import com.honca.hrms.models.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepositorie extends JpaRepository<Department,Long> {
    Department findByName(String name);
}
