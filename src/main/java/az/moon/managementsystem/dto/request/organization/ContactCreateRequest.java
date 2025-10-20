package az.moon.managementsystem.dto.request.organization;

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
    private String address;

}
