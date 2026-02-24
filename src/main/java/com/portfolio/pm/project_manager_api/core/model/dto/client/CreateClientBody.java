package com.portfolio.pm.project_manager_api.core.model.dto.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateClientBody(
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
        @Size(max = 20)
        String phone
) {
}
