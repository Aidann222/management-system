package az.moon.managementsystem.mapper;

import az.moon.managementsystem.dto.request.organization.ContactCreateRequest;
import az.moon.managementsystem.dto.response.contact.ContactCreateResponse;
import az.moon.managementsystem.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ContactMapper {
    Contact createRequestToEntity(ContactCreateRequest createRequest);

    ContactCreateResponse createResponseToEntity(Contact contact);

}
