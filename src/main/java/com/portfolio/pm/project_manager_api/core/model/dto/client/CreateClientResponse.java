package com.portfolio.pm.project_manager_api.core.model.dto.client;

import lombok.Builder;

@Builder
public record CreateClientResponse(
        boolean valid
) {
}
