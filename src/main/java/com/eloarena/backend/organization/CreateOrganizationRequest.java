package com.eloarena.backend.organization;

import jakarta.validation.constraints.NotBlank;

public record CreateOrganizationRequest(
        @NotBlank String name,
        String description,
        @NotBlank String organizationCode
) {
}
