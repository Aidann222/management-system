package az.moon.managementsystem.service.contact;

import az.moon.managementsystem.dto.request.organization.ContactCreateRequest;
import az.moon.managementsystem.dto.response.contact.ContactCreateResponse;
import az.moon.managementsystem.entity.Contact;

public interface ContactService {

    ContactCreateResponse createContact(ContactCreateRequest request);

}
