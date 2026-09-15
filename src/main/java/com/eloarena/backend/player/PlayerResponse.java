package com.eloarena.backend.player;

import java.time.Instant;
import java.util.UUID;

public record PlayerResponse(
        UUID id,
        String  name,
        Instant createdAt,
        UUID organizationId
) {
}
