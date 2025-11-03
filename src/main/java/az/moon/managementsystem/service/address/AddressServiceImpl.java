package az.moon.managementsystem.service.address;

import az.moon.managementsystem.contains.ManagementContains;
import az.moon.managementsystem.dto.request.address.AddressCreateRequest;
import az.moon.managementsystem.dto.request.address.AddressUpdateRequest;
import az.moon.managementsystem.dto.response.address.AddressCreateResponse;
import az.moon.managementsystem.dto.response.address.AddressReadResponse;
import az.moon.managementsystem.dto.response.address.AddressUpdateResponse;
import az.moon.managementsystem.entity.Address;
import az.moon.managementsystem.exception.notfound.AddressNotFoundException;
import az.moon.managementsystem.mapper.AddressMapper;
import az.moon.managementsystem.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressCreateResponse createAddress(AddressCreateRequest request){
        log.info("Address create request {}", request);
        Address address = addressMapper.createRequestToEntity(request);
        Address savedAddress = addressRepository.save(address);
        log.info("Address saved {}", savedAddress);
        AddressCreateResponse response = addressMapper.entityToCreateResponse(savedAddress);
        log.info("Address create response {}", response);
        return response;

    }

    @Override
    public List<AddressReadResponse> getAllAddresses() {
//        List<Address> addresses = addressRepository.findAll();
//        List<AddressReadResponse> readResponses = addressMapper.toReadResponseList(addresses);
//        log.info("All addresses {}", readResponses);
//        return readResponses;
        return addressRepository.findAll().stream().map(addressMapper::toReadResponse).toList();
    }

    @Override
    public AddressReadResponse getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(ManagementContains.ADDRESS_NOT_FOUND));
        return addressMapper.toReadResponse(address);
    }

    @Override
    public AddressUpdateResponse updateAddress(Long id, AddressUpdateRequest request) {
        // todo: 1.deyishmek isteidyin datani tap 2.tapdigin melumat uzerinde deyishiklik et
        //  3.deyishikliyi yaddashda saxla
        //  4.methodun teleb elediyi tipde yaddashda saxladigi melumati qaytar
        Address foundedAddress = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(ManagementContains.ADDRESS_NOT_FOUND));
        Address updatedAddress = addressMapper.updateRequestToEntity(request, foundedAddress);
        updatedAddress.setId(foundedAddress.getId());
        Address savedAddress = addressRepository.save(updatedAddress);
        return addressMapper.entityToUpdateResponse(savedAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        Address foundedAddress = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(ManagementContains.ADDRESS_NOT_FOUND));
        addressRepository.delete(foundedAddress);

    }

    @Override
    public void updateFromRequest(Long id, AddressUpdateRequest request) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(ManagementContains.ADDRESS_NOT_FOUND));
        addressMapper.updateRequestToEntity(request, address);
        addressRepository.save(address);



    }


}
