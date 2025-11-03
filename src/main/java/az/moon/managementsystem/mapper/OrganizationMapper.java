package az.moon.managementsystem.mapper;


import az.moon.managementsystem.dto.request.organization.OrganizationCreateRequest;
import az.moon.managementsystem.dto.request.organization.OrganizationStatusRequest;
import az.moon.managementsystem.dto.request.organization.OrganizationUpdateRequest;
import az.moon.managementsystem.dto.response.organization.OrganizationCreateResponse;
import az.moon.managementsystem.dto.response.organization.OrganizationReadResponse;
import az.moon.managementsystem.dto.response.organization.OrganizationUpdateResponse;
import az.moon.managementsystem.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrganizationMapper {
    Organization createRequestToEntity(OrganizationCreateRequest createRequest);

    OrganizationCreateResponse entityToCreateResponse(Organization organization);

    List<OrganizationReadResponse> toReadResponse(List<Organization> organizations);

    OrganizationReadResponse toReadResponse(Organization organization);

    Organization updateRequestToEntity(OrganizationUpdateRequest updateRequest);

    OrganizationUpdateResponse entityToUpdateResponse(Organization organization);

    Organization updateStatusFromRequest(OrganizationStatusRequest request);


}
