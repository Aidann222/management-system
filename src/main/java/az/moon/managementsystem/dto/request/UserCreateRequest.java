package az.moon.managementsystem.dto.request;


import az.moon.managementsystem.contant.validation.Username;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    @Username
    private String username;
    private String password;
    private String userEmail;
    private String phoneNumber;

}
