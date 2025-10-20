package az.moon.managementsystem.service.contact;

import az.moon.managementsystem.dto.request.organization.ContactCreateRequest;
import az.moon.managementsystem.dto.response.contact.ContactCreateResponse;
import az.moon.managementsystem.mapper.ContactMapper;
import az.moon.managementsystem.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;


    @Override
    public ContactCreateResponse createContact(ContactCreateRequest request) {
        return null;
    }
}
