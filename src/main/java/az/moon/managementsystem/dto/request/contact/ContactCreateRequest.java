package az.moon.managementsystem.dto.request.contact;

import az.moon.managementsystem.dto.request.address.AddressCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactCreateRequest {
    private String userEmail;
    private String callCenter;
    private String phoneNumber;
    private AddressCreateRequest address;

}
