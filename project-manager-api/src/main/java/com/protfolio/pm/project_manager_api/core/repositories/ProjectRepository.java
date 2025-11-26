package com.protfolio.pm.project_manager_api.core.repositories;

import com.protfolio.pm.project_manager_api.core.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // JpaRepository already provides save() and findAll() methods
}
