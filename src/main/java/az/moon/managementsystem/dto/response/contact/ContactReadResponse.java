package az.moon.managementsystem.dto.response.contact;

import az.moon.managementsystem.dto.response.address.AddressReadResponse;
import az.moon.managementsystem.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactReadResponse {

    private String email;
    private String phoneNumber;
    private AddressReadResponse addressResponse;
}
