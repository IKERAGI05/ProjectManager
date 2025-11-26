package com.protfolio.pm.project_manager_api.core.services;

import com.protfolio.pm.project_manager_api.core.model.entity.Project;
import com.protfolio.pm.project_manager_api.core.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
    public Project insertProject(Project project) {
        return projectRepository.save(project);
    }
}
