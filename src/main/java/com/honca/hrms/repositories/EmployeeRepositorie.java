package com.honca.hrms.repositories;

import com.honca.hrms.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositorie extends JpaRepository<Employee,Long> {
}
