package com.eloarena.backend.player;

import com.eloarena.backend.organization.Organization;
import com.eloarena.backend.organization.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final OrganizationService organizationService;

    public PlayerService(
            PlayerRepository playerRepository,
            OrganizationService organizationService){
        this.playerRepository = playerRepository;
        this.organizationService = organizationService;
    }

    public PlayerResponse createPlayer(
            String name,
            UUID organizationId
    ){
        Organization organization = organizationService.findOrganizationById(organizationId);
        Player player = playerRepository.save(
                new Player(name, organization)
        );
        return toResponse(player);
    }

    private PlayerResponse toResponse(Player player){
        return new PlayerResponse(
                player.getId(),
                player.getName(),
                player.getCreatedAt(),
                player.getOrganization().getId()
        );
    }


}
