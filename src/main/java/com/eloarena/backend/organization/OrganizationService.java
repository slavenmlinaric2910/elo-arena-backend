package com.eloarena.backend.organization;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

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
            throw new OrganizationCodeAlreadyExistsException();
        }

        Organization organization = new Organization(name, description, normalizedCode);

        return organizationRepository.save(organization);
     }

     public List<OrganizationResponse> getAllOrganizations(){
        return organizationRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();

     }

     public OrganizationResponse getOrganizationById(UUID id){
         Organization organization = organizationRepository
                 .findById(id)
                 .orElseThrow(() -> new OrganizationNotFoundException(id));

         return toResponse(organization);

     }

    private OrganizationResponse toResponse(Organization organization) {
        return new OrganizationResponse(
                organization.getId(),
                organization.getName(),
                organization.getDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedAt()
        );
    }
}
