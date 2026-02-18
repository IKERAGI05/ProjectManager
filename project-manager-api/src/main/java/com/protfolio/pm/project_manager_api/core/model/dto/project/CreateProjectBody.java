package com.protfolio.pm.project_manager_api.core.model.dto.project;

import com.protfolio.pm.project_manager_api.core.model.enums.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateProjectBody(
        @NotBlank(message = "Project name is required")
        String name,

        String description,

        @NotNull(message = "Start date is required")
        LocalDate startDate,

        @NotNull(message = "Deadline date is required")
        LocalDate deadlineDate,

        @NotNull(message = "Client ID is required")
        Long clientId,

        @NotNull(message = "Project status is required")
        ProjectStatus status
) {
}
