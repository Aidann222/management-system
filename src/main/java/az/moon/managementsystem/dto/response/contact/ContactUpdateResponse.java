package az.moon.managementsystem.dto.response.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactUpdateResponse {

    private Integer id;
    private String email;
    private String callCenter;
    private String phoneNumber;
    private String address;
}
