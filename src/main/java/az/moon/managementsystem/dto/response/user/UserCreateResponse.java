package az.moon.managementsystem.dto.response.user;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponse {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private LocalDateTime created;
    private String createdBy;

}