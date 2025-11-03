package az.moon.managementsystem.mapper;

import az.moon.managementsystem.dto.request.address.AddressCreateRequest;
import az.moon.managementsystem.dto.request.address.AddressUpdateRequest;
import az.moon.managementsystem.dto.response.address.AddressCreateResponse;
import az.moon.managementsystem.dto.response.address.AddressReadResponse;
import az.moon.managementsystem.dto.response.address.AddressUpdateResponse;
import az.moon.managementsystem.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    @Mapping(target = "address", source = "street")
    Address createRequestToEntity(AddressCreateRequest createRequest);

    AddressCreateResponse entityToCreateResponse(Address address);

    List<AddressReadResponse> toReadResponseList(List<Address> addresses);

    AddressReadResponse toReadResponse(Address address);

    AddressUpdateResponse entityToUpdateResponse(Address address);

    @Mapping(target = "address", source = "street")
    Address updateRequestToEntity(AddressUpdateRequest updateRequest, @MappingTarget Address address);



}
