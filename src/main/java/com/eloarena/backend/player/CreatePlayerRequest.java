package com.eloarena.backend.player;

import jakarta.validation.constraints.NotBlank;

public record CreatePlayerRequest(
        @NotBlank String name
) {
}
