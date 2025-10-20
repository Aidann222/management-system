package az.moon.managementsystem.dto.response.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationReadResponse {

    private String name;
    private Boolean status;
}
