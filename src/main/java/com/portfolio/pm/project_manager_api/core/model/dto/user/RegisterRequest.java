package com.portfolio.pm.project_manager_api.core.model.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegisterRequest(
        @NotBlank
        @Size(max = 100)
        String name,
        @NotBlank
        @Size(max = 100)
        String surname,
        @NotBlank
        @Email
        @Size(max = 150)
        String email,
        @NotBlank
        @Size(min = 3, max = 50)
        String username,
        @NotBlank
        @Size(min = 6, max = 100)
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
        String password
) {
}
