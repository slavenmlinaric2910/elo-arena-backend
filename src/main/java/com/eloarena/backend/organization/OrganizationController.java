package com.eloarena.backend.organization;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }



    @PostMapping
    public ResponseEntity<OrganizationResponse> createOrganization(
            @Valid @RequestBody CreateOrganizationRequest request
    ) {
        OrganizationResponse organization = organizationService.createOrganization(
                request.name(),
                request.description(),
                request.organizationCode()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(organization);
    }

    @GetMapping
    public List<OrganizationResponse> getAllOrganizations(){
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public OrganizationResponse getOrganizationById(@PathVariable UUID id){
        return organizationService.getOrganizationById(id);
    }
}
