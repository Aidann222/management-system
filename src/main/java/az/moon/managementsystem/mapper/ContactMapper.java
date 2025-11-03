package az.moon.managementsystem.mapper;

import az.moon.managementsystem.dto.request.contact.ContactCreateRequest;
import az.moon.managementsystem.dto.request.contact.ContactUpdateRequest;
import az.moon.managementsystem.dto.response.contact.ContactCreateResponse;
import az.moon.managementsystem.dto.response.contact.ContactReadResponse;
import az.moon.managementsystem.dto.response.contact.ContactUpdateResponse;
import az.moon.managementsystem.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ContactMapper {
    @Mapping(target = "email", source = "userEmail")
    Contact createRequestToEntity(ContactCreateRequest createRequest);

    @Mapping(target = "phone", source = "phoneNumber")
    ContactCreateResponse entityToCreateResponse(Contact contact);

    List<ContactReadResponse> toReadResponseList(List<Contact> contacts);

    ContactReadResponse contactToReadResponse(Contact contact);

    ContactUpdateResponse entityToUpdateResponse(Contact contact);

}
