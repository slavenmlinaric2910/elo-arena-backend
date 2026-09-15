package com.eloarena.backend.player;

import com.eloarena.backend.organization.Organization;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    @NotBlank
    private String name;
    @Column(nullable = false)
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    protected Player() {}

    public Player(String name, Organization organization){
        this.name = name;
        this.organization = organization;
        this.createdAt = Instant.now();
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Instant getCreatedAt(){
        return createdAt;
    }

    public Organization getOrganization(){
        return organization;
    }


}
