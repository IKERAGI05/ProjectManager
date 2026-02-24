package com.portfolio.pm.project_manager_api.core.model.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LoginRequest(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
