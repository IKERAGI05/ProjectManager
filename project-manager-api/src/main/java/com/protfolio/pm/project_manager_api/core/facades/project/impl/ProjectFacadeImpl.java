package com.protfolio.pm.project_manager_api.core.facades.project.impl;

import com.protfolio.pm.project_manager_api.core.facades.project.ProjectFacade;
import com.protfolio.pm.project_manager_api.core.model.dto.project.CreateProjectBody;
import com.protfolio.pm.project_manager_api.core.model.dto.project.CreateProjectResponse;
import com.protfolio.pm.project_manager_api.core.model.dto.project.ProjectsReturn;
import com.protfolio.pm.project_manager_api.core.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectFacadeImpl implements ProjectFacade {

    private final ProjectService projectService;

    @Override
    public List<ProjectsReturn> getProjects() {
        return projectService.getAllProjects();
    }

    @Override
    public ProjectsReturn getProjectById(Long id) {
        return projectService.getProjectById(id);
    }

    @Override
    public CreateProjectResponse insertProject(CreateProjectBody body) {
        return projectService.insertProject(body);
    }
}
