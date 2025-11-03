package az.moon.managementsystem.service.contact;

import az.moon.managementsystem.contains.ManagementContains;
import az.moon.managementsystem.dto.request.contact.ContactCreateRequest;
import az.moon.managementsystem.dto.request.contact.ContactUpdateRequest;
import az.moon.managementsystem.dto.response.contact.ContactCreateResponse;
import az.moon.managementsystem.dto.response.contact.ContactReadResponse;
import az.moon.managementsystem.dto.response.contact.ContactUpdateResponse;
import az.moon.managementsystem.entity.Contact;
import az.moon.managementsystem.exception.notfound.OrganizationNotFoundException;
import az.moon.managementsystem.mapper.ContactMapper;
import az.moon.managementsystem.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;


    @Override
    public ContactCreateResponse createContact(ContactCreateRequest request) {
        log.info("Create contact request {}", request);
        Contact contact = contactMapper.createRequestToEntity(request);
        Contact savedContact = contactRepository.save(contact);
        log.info("Save it contact {}", savedContact);
        log.info("Contact response {}", contactMapper.entityToCreateResponse(savedContact));
        return contactMapper.entityToCreateResponse(savedContact);

    }

    @Override
    public List<ContactReadResponse> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contactMapper.toReadResponseList(contacts);
    }

    @Override
    public ContactReadResponse getContactById(Integer id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(ManagementContains.CONTACT_ALREADY_EXISTS));
        return contactMapper.contactToReadResponse(contact);
    }

    @Override
    public ContactUpdateResponse updateContact(ContactUpdateRequest request, Integer id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(ManagementContains.CONTACT_NOT_FOUND));
        return contactMapper.entityToUpdateResponse(contact);
    }

    @Override
    public void deleteContact(Integer id) {
        Contact foundedContact  = contactRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(ManagementContains.CONTACT_ALREADY_EXISTS));
        contactRepository.delete(foundedContact);

    }

}
