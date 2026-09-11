package com.eloarena.backend.organization;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

     public Organization createOrganization(
             String name,
             String description,
             String organizationCode
     ){
        String normalizedCode = organizationCode
                .trim()
                .toUpperCase(Locale.ROOT)
                .replaceAll("\\s+", "-");

        if(organizationRepository.existsByOrganizationCodeIgnoreCase(normalizedCode)){
            throw new OrganizationCodeAlreadyExistsException("Organization code already exists");
        }

        Organization organization = new Organization(name, description, normalizedCode);

        return organizationRepository.save(organization);
     }
}
