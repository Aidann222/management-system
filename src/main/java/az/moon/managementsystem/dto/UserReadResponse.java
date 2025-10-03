package az.moon.managementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReadResponse {

    private String username;
    private String email;
    private LocalDateTime created;
    private LocalDateTime modified;

}
