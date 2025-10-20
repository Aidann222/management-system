package az.moon.managementsystem.controller;


import az.moon.managementsystem.dto.request.organization.OrganizationCreateRequest;
import az.moon.managementsystem.dto.request.organization.OrganizationUpdateRequest;
import az.moon.managementsystem.dto.response.organization.OrganizationCreateResponse;
import az.moon.managementsystem.dto.response.organization.OrganizationReadResponse;
import az.moon.managementsystem.dto.response.organization.OrganizationUpdateResponse;
import az.moon.managementsystem.entity.Organization;
import az.moon.managementsystem.service.organization.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping("/create")
    public OrganizationCreateResponse createOrganization(@RequestBody OrganizationCreateRequest request) {
        return organizationService.createOrganization(request);
    }

    @GetMapping("/all")
    public List<OrganizationReadResponse> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @PutMapping("/{organizationId}")
    public OrganizationUpdateResponse updateOrganization(@PathVariable(name = "organizationId") Long organizationId
    , @RequestBody OrganizationUpdateRequest request) {
        return organizationService.updateOrganization(organizationId, request);
    }

    @DeleteMapping("/delete")
    public void deleteOrganization(@PathVariable(name = "organizationId") Long organizationId) {
        organizationService.deleteOrganization(organizationId);
    }

    @GetMapping("/status")
    public List<OrganizationReadResponse> getOrganizationStatus(@RequestParam(name = "status") Boolean status) {
        return organizationService.getAllStatus(status);

    }
}
