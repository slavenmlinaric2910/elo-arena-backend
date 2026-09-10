package com.eloarena.backend.organization;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrganizationRepository extends JpaRepository<Organization, UUID> {

    boolean existsByOrganizationCodeIgnoreCase(String organizationCode);
}
