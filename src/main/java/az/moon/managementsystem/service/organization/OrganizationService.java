package az.moon.managementsystem.service.organization;


import az.moon.managementsystem.dto.request.organization.OrganizationCreateRequest;
import az.moon.managementsystem.dto.request.organization.OrganizationStatusRequest;
import az.moon.managementsystem.dto.request.organization.OrganizationUpdateRequest;
import az.moon.managementsystem.dto.response.organization.OrganizationCreateResponse;
import az.moon.managementsystem.dto.response.organization.OrganizationReadResponse;
import az.moon.managementsystem.dto.response.organization.OrganizationUpdateResponse;

import java.util.List;

public interface OrganizationService {

    OrganizationCreateResponse createOrganization(OrganizationCreateRequest request);

    List<OrganizationReadResponse> getAllOrganizations();

    OrganizationReadResponse getOrganizationById(Long id);

    OrganizationUpdateResponse updateOrganization(Long id, OrganizationUpdateRequest request);

    void deleteOrganization(Long id);

    Boolean getByName(String name);

    List<OrganizationReadResponse> getAllStatus(Boolean status);

    OrganizationUpdateResponse updateOrganizationStatus(Long id, OrganizationStatusRequest request);


}
