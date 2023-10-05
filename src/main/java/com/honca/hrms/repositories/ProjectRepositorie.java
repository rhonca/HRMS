package com.honca.hrms.repositories;

import com.honca.hrms.models.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepositorie extends JpaRepository<Project,Long> {
}
