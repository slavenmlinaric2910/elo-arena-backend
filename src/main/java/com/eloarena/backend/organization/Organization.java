package com.eloarena.backend.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.UUID;


@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    @NotBlank
    private String name;
    private String description;
    @Column(nullable = false, unique = true)
    @NotBlank
    private String organizationCode;
    @Column(nullable = false)
    private Instant createdAt;

    protected Organization() {}

    public Organization(String name, String description, String organizationCode){
        this.name = name;
        this.description = description;
        this.organizationCode = organizationCode;
        this.createdAt = Instant.now();
    }

    public UUID getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getOrganizationCode(){
        return organizationCode;
    }
    public Instant getCreatedAt(){
        return createdAt;
    }
}
