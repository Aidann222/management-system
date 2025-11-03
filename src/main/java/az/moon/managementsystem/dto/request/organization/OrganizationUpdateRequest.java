package az.moon.managementsystem.dto.request.organization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationUpdateRequest {

    private String name;
    private String description;
    private String website;
    private String phoneNumber;
}
