package az.moon.managementsystem.service.organization;

import az.moon.managementsystem.contains.ManagementContains;
import az.moon.managementsystem.dto.request.organization.ContactCreateRequest;
import az.moon.managementsystem.dto.request.organization.OrganizationCreateRequest;
import az.moon.managementsystem.dto.request.organization.OrganizationUpdateRequest;
import az.moon.managementsystem.dto.response.organization.OrganizationCreateResponse;
import az.moon.managementsystem.dto.response.organization.OrganizationReadResponse;
import az.moon.managementsystem.dto.response.organization.OrganizationUpdateResponse;
import az.moon.managementsystem.entity.Organization;
import az.moon.managementsystem.exception.exits.AlreadyExistsException;
import az.moon.managementsystem.exception.notfound.OrganizationNotFoundException;
import az.moon.managementsystem.mapper.ContactMapper;
import az.moon.managementsystem.mapper.OrganizationMapper;
import az.moon.managementsystem.repository.OrganizationRepository;
import az.moon.managementsystem.service.contact.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;
    private final ContactService contactService;


    @Override
    public OrganizationCreateResponse createOrganization(OrganizationCreateRequest request) {
        Boolean checkName = getByName(request.getName());

        if (!checkName) {
            Organization organization = organizationMapper.createRequestToEntity(request);
            Organization savedOrganization = organizationRepository.save(organization);
            ContactCreateRequest  contactCreateRequest = request.getContactDetail();
            contactService.createContact(contactCreateRequest);
            return organizationMapper.entityToCreateResponse(savedOrganization);
        } else {
            throw new AlreadyExistsException(ManagementContains.ORGANIZATION_ALREADY_EXISTS);
        }
    }

    @Override
    public List<OrganizationReadResponse> getAllOrganizations() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizationMapper.toReadResponse(organizations);
    }

    @Override
    public OrganizationReadResponse getOrganizationById(Long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(ManagementContains.ORGANIZATION_NOT_FOUND));
        return organizationMapper.toReadResponse(organization);


    }

    @Override
    public OrganizationUpdateResponse updateOrganization(Long id, OrganizationUpdateRequest request) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(ManagementContains.ALREADY_EXISTS));
        return organizationMapper.entityToUpdateResponse(organization);
    }

    @Override
    public void deleteOrganization(Long id) {
        Organization foundedOrganization = organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(ManagementContains.ORGANIZATION_NOT_FOUND));
        organizationRepository.delete(foundedOrganization);

    }

    @Override
    public Boolean getByName(String name) {
        Optional<Organization> organization = organizationRepository.findByName(name);
        if (organization.isPresent()) {
            return true;
        } else {
            return false;
        }

        //return organization.map(organizationMapper::toReadResponse).orElse(null);//ispresent or null
    }

    @Override
    public List<OrganizationReadResponse> getAllStatus(Boolean status) {
        List<Organization> organizations = organizationRepository.getAllByStatus(status);
        return organizationMapper.toReadResponse(organizations);
    }


}
