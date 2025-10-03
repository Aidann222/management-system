package az.moon.managementsystem.service;




import az.moon.managementsystem.dto.UserReadResponse;
import az.moon.managementsystem.dto.request.UserCreateRequest;
import az.moon.managementsystem.dto.response.UserCreateResponse;

import java.util.List;

public interface UserManagementService {

    UserCreateResponse createUserManagement(UserCreateRequest userCreateRequest);

    List<UserReadResponse> getAllUsers();

    UserReadResponse getUserById(Long userId);
}
