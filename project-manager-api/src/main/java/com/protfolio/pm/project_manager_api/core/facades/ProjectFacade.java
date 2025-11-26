package com.protfolio.pm.project_manager_api.core.facades;

import com.protfolio.pm.project_manager_api.core.model.entity.Project;
import com.protfolio.pm.project_manager_api.core.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectFacade {

    @Autowired
    private ProjectService projectService;


    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }
    
    public Project insertProject(Project project) {
        return projectService.insertProject(project);
    }
}
