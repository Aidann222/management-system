package az.moon.managementsystem.service.address;

import az.moon.managementsystem.dto.request.address.AddressCreateRequest;
import az.moon.managementsystem.dto.request.address.AddressUpdateRequest;
import az.moon.managementsystem.dto.response.address.AddressCreateResponse;
import az.moon.managementsystem.dto.response.address.AddressReadResponse;
import az.moon.managementsystem.dto.response.address.AddressUpdateResponse;
import az.moon.managementsystem.entity.Address;

import java.util.List;

public interface AddressService {

    AddressCreateResponse createAddress(AddressCreateRequest request);

    List<AddressReadResponse> getAllAddresses();

    AddressReadResponse getAddressById(Long id);

    AddressUpdateResponse updateAddress(Long id, AddressUpdateRequest request);

    void deleteAddress(Long id);

    void updateFromRequest(Long id, AddressUpdateRequest request);
}
