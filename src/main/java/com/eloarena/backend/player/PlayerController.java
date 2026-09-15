package com.eloarena.backend.player;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/organizations/{organizationId}/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerResponse> createPlayer(
            @Valid @RequestBody CreatePlayerRequest request,
            @PathVariable("organizationId") UUID organizationId
    ){
        PlayerResponse player = playerService.createPlayer(
                request.name(),
                organizationId
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }
}
