package com.portfolio.pm.project_manager_api.core.services;

import com.portfolio.pm.project_manager_api.core.model.dto.project.CreateProjectBody;
import com.portfolio.pm.project_manager_api.core.model.dto.project.CreateProjectResponse;
import com.portfolio.pm.project_manager_api.core.model.dto.project.ProjectsReturn;

import java.util.List;

public interface ProjectService {

    List<ProjectsReturn> getAllProjects();

    ProjectsReturn getProjectById(Long id);

    CreateProjectResponse insertProject(CreateProjectBody body);
}
