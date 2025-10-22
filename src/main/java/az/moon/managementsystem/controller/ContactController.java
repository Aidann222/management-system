package az.moon.managementsystem.controller;

import az.moon.managementsystem.dto.request.organization.ContactCreateRequest;
import az.moon.managementsystem.dto.response.contact.ContactCreateResponse;
import az.moon.managementsystem.service.contact.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/save")
    public ContactCreateResponse createContact(@RequestBody ContactCreateRequest request) {
        return contactService.createContact(request);
    }


}
