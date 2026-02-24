package com.portfolio.pm.project_manager_api.core.model.dto.user;

import lombok.Builder;

@Builder
public record AuthResponse(
        boolean success,
        String message,
        String token,
        UserInfo user
) {
    
    @Builder
    public record UserInfo(
            Long id,
            String username,
            String email,
            String name,
            String surname
    ) {
    }
}
