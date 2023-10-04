package com.honca.hrms.repositories;

import com.honca.hrms.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepositorie extends JpaRepository<Project,Long> {
}
