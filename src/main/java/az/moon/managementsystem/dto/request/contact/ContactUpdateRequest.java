package az.moon.managementsystem.dto.request.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactUpdateRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
