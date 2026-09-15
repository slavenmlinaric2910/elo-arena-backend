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

     public OrganizationResponse createOrganization(
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

         Organization organization = organizationRepository.save(
                 new Organization(name, description, normalizedCode)
         );

         return toResponse(organization);
     }

     public List<OrganizationResponse> getAllOrganizations(){
        return organizationRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();

     }

    public Organization findOrganizationById(UUID id) {
        return organizationRepository
                .findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(id));
    }


    public OrganizationResponse getOrganizationById(UUID id){
         return toResponse(findOrganizationById(id));
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
