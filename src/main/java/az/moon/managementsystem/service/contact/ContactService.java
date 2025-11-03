package az.moon.managementsystem.service.contact;

import az.moon.managementsystem.dto.request.contact.ContactCreateRequest;
import az.moon.managementsystem.dto.request.contact.ContactUpdateRequest;
import az.moon.managementsystem.dto.response.contact.ContactCreateResponse;
import az.moon.managementsystem.dto.response.contact.ContactReadResponse;
import az.moon.managementsystem.dto.response.contact.ContactUpdateResponse;

import java.util.List;

public interface ContactService {

    ContactCreateResponse createContact(ContactCreateRequest request);

    List<ContactReadResponse> getAllContacts();

    ContactReadResponse getContactById(Integer id); //long yoxsa integer

    ContactUpdateResponse updateContact(ContactUpdateRequest request, Integer id);

    void deleteContact(Integer id);

}
