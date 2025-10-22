package az.moon.managementsystem.dto.response.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactCreateResponse {
    private Long id;
    private String callCenter;
    private String phone;
    private String email;
}
