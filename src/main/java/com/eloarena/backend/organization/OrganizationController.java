package com.eloarena.backend.organization;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }



    @PostMapping
    public ResponseEntity<Organization> createOrganization(
            @Valid @RequestBody CreateOrganizationRequest request
    ) {
        Organization organization = organizationService.createOrganization(
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
}
