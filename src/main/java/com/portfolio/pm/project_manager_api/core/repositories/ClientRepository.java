package com.portfolio.pm.project_manager_api.core.repositories;

import com.portfolio.pm.project_manager_api.infrastructure.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // JpaRepository already provides save() and findAll() methods
}
