package az.moon.managementsystem.dto.response.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationUpdateResponse {

    private Long id;
    private String name;
    private String description;
    private Boolean status;
    private Integer contactId;
    private LocalDateTime created;
    private String createdBy;
}
