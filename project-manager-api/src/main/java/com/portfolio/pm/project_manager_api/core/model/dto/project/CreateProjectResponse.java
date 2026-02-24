package com.portfolio.pm.project_manager_api.core.model.dto.project;

import lombok.Builder;

@Builder
public record CreateProjectResponse(
        Long id,
        String name
) {
}
