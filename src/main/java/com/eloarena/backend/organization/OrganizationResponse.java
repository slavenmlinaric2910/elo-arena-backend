package com.eloarena.backend.organization;

import java.time.Instant;
import java.util.UUID;

public record OrganizationResponse(
        UUID id,
        String name,
        String description,
        String organizationCode,
        Instant createdAt
) {}