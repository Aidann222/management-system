package az.moon.managementsystem.controller;

import az.moon.managementsystem.dto.request.address.AddressCreateRequest;
import az.moon.managementsystem.dto.response.address.AddressCreateResponse;
import az.moon.managementsystem.service.address.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/create")
    public AddressCreateResponse createAddress(@RequestBody AddressCreateRequest request) {
        return addressService.createAddress(request);

    }
}
