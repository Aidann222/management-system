package az.moon.managementsystem.dto.request.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationCreateRequest {

    private String name;
    private Boolean status;
    private Integer contactId;

}
