package com.portfolio.pm.project_manager_api.core.model.dto.project;

import com.portfolio.pm.project_manager_api.core.model.enums.ProjectStatus;
import com.portfolio.pm.project_manager_api.core.model.dto.client.ClientReturn;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ProjectsReturn(
        Long id,
        String name,
        String description,
        LocalDate startDate,
        LocalDate deadlineDate,
        ClientReturn client,
        ProjectStatus status
) {
}
