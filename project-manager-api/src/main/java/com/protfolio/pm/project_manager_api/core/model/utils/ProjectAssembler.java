package com.protfolio.pm.project_manager_api.core.model.utils;

import com.protfolio.pm.project_manager_api.core.model.dto.client.ClientReturn;
import com.protfolio.pm.project_manager_api.core.model.dto.project.CreateProjectBody;
import com.protfolio.pm.project_manager_api.core.model.dto.project.ProjectsReturn;
import com.protfolio.pm.project_manager_api.infrastructure.entity.Client;
import com.protfolio.pm.project_manager_api.infrastructure.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectAssembler {

    public static Project buildEntity(CreateProjectBody body, Client client) {
        return Project.builder()
                .name(body.name())
                .description(body.description())
                .startDate(body.startDate())
                .deadlineDate(body.deadlineDate())
                .client(client)
                .status(body.status())
                .build();
    }

    public static List<ProjectsReturn> buildResponse(List<Project> projectList) {
        List<ProjectsReturn> ret = new ArrayList<>();

        projectList.forEach(p -> {
            ProjectsReturn projectsReturn = ProjectsReturn.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .description(p.getDescription())
                    .startDate(p.getStartDate())
                    .deadlineDate(p.getDeadlineDate())
                    .client(ClientReturn.builder()
                            .id(p.getClient().getId())
                            .name(p.getClient().getName())
                            .surname(p.getClient().getSurname())
                            .email(p.getClient().getEmail())
                            .phone(p.getClient().getPhone())
                            .build())
                    .status(p.getStatus())
                    .build();
            ret.add(projectsReturn);
        });
        return ret;
    }

    public static ProjectsReturn buildResponseById(Project project) {
        return ProjectsReturn.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .deadlineDate(project.getDeadlineDate())
                .client(ClientReturn.builder()
                        .id(project.getClient().getId())
                        .name(project.getClient().getName())
                        .surname(project.getClient().getSurname())
                        .email(project.getClient().getEmail())
                        .phone(project.getClient().getPhone())
                        .build())
                .status(project.getStatus())
                .build();
    }
}
