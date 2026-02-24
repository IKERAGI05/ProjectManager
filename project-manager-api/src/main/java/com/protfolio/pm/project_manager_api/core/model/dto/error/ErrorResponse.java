package com.protfolio.pm.project_manager_api.core.model.dto.error;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse(
        String error,
        String message,
        LocalDateTime timestamp,
        String path,
        String errorMessageCode
) {
}
