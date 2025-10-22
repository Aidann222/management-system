package az.moon.managementsystem.service.contact;

import az.moon.managementsystem.dto.request.organization.ContactCreateRequest;
import az.moon.managementsystem.dto.response.contact.ContactCreateResponse;
import az.moon.managementsystem.entity.Contact;
import az.moon.managementsystem.mapper.ContactMapper;
import az.moon.managementsystem.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
