package com.portfolio.pm.project_manager_api.core.model.dto.client;

import lombok.Builder;

@Builder
public record ClientReturn(
        Long id,
        String name,
        String surname,
        String email,
        String phone
) {
}
